package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.*;
import com.cognizant.airline_ticket_reservation_system.service.FlightBookingService;
import com.cognizant.airline_ticket_reservation_system.service.FlightScheduleService;
import com.cognizant.airline_ticket_reservation_system.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class BookTicketController {
    private FlightScheduleService flightScheduleService;
    private FlightService flightService;
    private FlightBookingService flightBookingService;

    @Autowired
    public void setFlightScheduleService(FlightScheduleService flightScheduleService) {
        this.flightScheduleService = flightScheduleService;
    }

    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @Autowired
    public void setFlightBookingService(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }

    @GetMapping("/user/user-home/book-ticket")
    public ModelAndView bookTicket(@ModelAttribute("bookTicket") BookTicket bookTicket) {
        return new ModelAndView("/user/user_home/book-ticket");
    }

    @PostMapping("/user/user-home/book-ticket")
    public ModelAndView flightSearch(
            @Valid @ModelAttribute("bookTicket") BookTicket bookTicket,
            BindingResult bindingResult,
            ModelAndView modelAndView
    ) {
        // Check if booking date in the past
        if (bookTicket.getDate() != null && bookTicket.getDate().compareTo(LocalDate.now()) < 0) {
            bindingResult.rejectValue("date", "error.bookTicket.date.past");
        }

        // Check if source and destination are same
        if (
                bookTicket.getSource() != null &&
                        bookTicket.getDestination() != null
                        && bookTicket.getSource().equals(bookTicket.getDestination())
        ) {
            bindingResult.rejectValue("destination", "error.bookTicket.destination.equal");
        }


        if (bindingResult.hasErrors()) {
            modelAndView.addObject("showFlight", false);
            modelAndView.setViewName("user/user_home/book-ticket");

            return modelAndView;
        }

        modelAndView.addObject("showFlight", true);

        List<FlightSchedule> flightSchedules = flightScheduleService.getFlightSchedulesByDateSourceDestination(bookTicket);

        for (FlightSchedule flightSchedule : flightSchedules) {
            Flight flight = flightService.getFlightByNo(flightSchedule.getFlightNo());
            flightSchedule.setFlight(flight);
        }

        if (!flightSchedules.isEmpty()) {
            modelAndView.addObject("flightsFound", true);
            modelAndView.addObject("flightSchedules", flightSchedules);
        }

        modelAndView.setViewName("/user/user_home/book-ticket");

        return modelAndView;
    }

    @GetMapping("/user/user-home/book-ticket/book-flight/{flightScheduleId}")
    public ModelAndView bookFlight(
            @PathVariable("flightScheduleId") Integer flightScheduleId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @ModelAttribute("passengerSeats") PassengerSeats passengerSeats,
            ModelAndView modelAndView,
            HttpServletRequest request
    ) {
        User user = (User) request.getSession().getAttribute("user");
        FlightSchedule flightSchedule = flightScheduleService.getFlightScheduleById(flightScheduleId);
        Flight flight = flightService.getFlightByNo(flightSchedule.getFlightNo());

        // Check if the flight is scheduled or not
        FlightBooking flightBooking = flightBookingService.getFlightBookingByFlightScheduledIdAndDate(flightScheduleId, date);

        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setFlightSchedule(flightSchedule);
        ticket.setFlight(flight);
        ticket.setDate(date);

        if (flightBooking != null) {
            ticket.setEconomySeatsAvailable(flightBooking.getEconomySeatsAvailable());
            ticket.setBusinessSeatsAvailable(flightBooking.getBusinessSeatsAvailable());
            ticket.setFlightIsScheduled(true);
            ticket.setFlightBookingId(flightBooking.getId());
        } else {
            ticket.setEconomySeatsAvailable(flight.getEconomySeats());
            ticket.setBusinessSeatsAvailable(flight.getBusinessSeats());
            ticket.setFlightIsScheduled(false);
        }

        ticket.setPassengerSeats(passengerSeats);

        // Add ticket object in the session
        request.getSession().setAttribute("ticket", ticket);

        modelAndView.setViewName("redirect:/user/user-home/book-ticket/passenger-seats");

        return modelAndView;
    }

    @GetMapping("/user/user-home/book-ticket/passenger-seats")
    public ModelAndView passengerSeats(
            @ModelAttribute("passengerSeats") PassengerSeats passengerSeats,
            ModelAndView modelAndView,
            HttpServletRequest request
    ) {
        Ticket ticket = (Ticket) request.getSession().getAttribute("ticket");

        if (ticket.getEconomySeatsAvailable() == 0 && ticket.getBusinessSeatsAvailable() == 0) {
            modelAndView.addObject("errorMessage", "Seat not available");
        }

        modelAndView.setViewName("user/user_home/book_ticket/passenger-seats");

        return modelAndView;
    }

    @PostMapping("/user/user-home/book-ticket/passenger-seats")
    public ModelAndView passengerSeats(
            @Valid @ModelAttribute("passengerSeats") PassengerSeats passengerSeats,
            BindingResult bindingResult,
            ModelAndView modelAndView,
            HttpServletRequest request
    ) {
        Ticket ticket = (Ticket) request.getSession().getAttribute("ticket");

        if (ticket.getEconomySeatsAvailable() == 0 && ticket.getBusinessSeatsAvailable() == 0) {
            modelAndView.addObject("errorMessage", "Seat not available");
        }

        if (passengerSeats.getEconomySeats() != null && passengerSeats.getEconomySeats() > ticket.getEconomySeatsAvailable()) {
            bindingResult.rejectValue("economySeats", "error.passengerSeats.economySeats.unavailable");
        }

        if (passengerSeats.getBusinessSeats() != null && passengerSeats.getBusinessSeats() > ticket.getBusinessSeatsAvailable()) {
            bindingResult.rejectValue("businessSeats", "error.passengerSeats.businessSeats.unavailable");
        }

        if (passengerSeats.getBusinessSeats() != null && passengerSeats.getEconomySeats() != null) {
            if (passengerSeats.getEconomySeats() == 0 && passengerSeats.getBusinessSeats() == 0) {
                bindingResult.rejectValue("economySeats", "error.passengerSeats.bothZero");
            }
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("user/user_home/book_ticket/passenger-seats");
            return modelAndView;
        }

        ticket.setPassengerSeats(passengerSeats);
        // Change seat availability number
        ticket.setEconomySeatsAvailable(ticket.getEconomySeatsAvailable() - passengerSeats.getEconomySeats());
        ticket.setBusinessSeatsAvailable(ticket.getBusinessSeatsAvailable() - passengerSeats.getBusinessSeats());

        modelAndView.setViewName("redirect:/user/user-home/book-ticket/passenger-entry");

        return modelAndView;
    }

    @GetMapping("/user/user-home/book-ticket/passenger-entry")
    public ModelAndView passengerSeats(
            ModelAndView modelAndView,
            BindingResult bindingResult,
            HttpServletRequest request
    ) {
        Ticket ticket = (Ticket) request.getSession().getAttribute("ticket");

        modelAndView.addObject("totalPassenger", ticket.getPassengerSeats().getTotalPassengerCount());
        modelAndView.setViewName("user/user_home/book_ticket/passenger-entry");

        return modelAndView;
    }

    @PostMapping("/user/user-home/book-ticket/passenger-entry")
    public void passengersDetails(
            @RequestBody List<Passenger> passengers,
            HttpServletRequest request
    ) {
        Ticket ticket = (Ticket) request.getSession().getAttribute("ticket");
        ticket.setPassengers(passengers);
    }

    @GetMapping("/user/user-home/book-ticket/booking-details")
    public ModelAndView bookingDetails(HttpServletRequest request) {
        Ticket ticket = (Ticket) request.getSession().getAttribute("ticket");
        FlightSchedule flightSchedule = ticket.getFlightSchedule();
        PassengerSeats passengerSeats = ticket.getPassengerSeats();

        // Calculate ticket cost
        int cost = flightSchedule.getBusinessSeatCost() * passengerSeats.getBusinessSeats() +
                flightSchedule.getEconomySeatCost() * passengerSeats.getEconomySeats();
        ticket.setCost(cost);

        return new ModelAndView("user/user_home/book_ticket/booking-details");
    }

    @ModelAttribute("sources")
    private List<String> sources(@Value("#{'${flightSchedule.sources}'.split(',')}") List<String> sources) {
        return sources;
    }

    @ModelAttribute("destinations")
    private List<String> destinations(@Value("#{'${flightSchedule.destinations}'.split(',')}") List<String> destinations) {
        return destinations;
    }
}
