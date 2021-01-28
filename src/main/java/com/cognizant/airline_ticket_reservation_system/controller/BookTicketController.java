package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.*;
import com.cognizant.airline_ticket_reservation_system.service.AccountService;
import com.cognizant.airline_ticket_reservation_system.service.BankService;
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
    private BankService bankService;
    private AccountService accountService;

    @Autowired
    public void setFlightScheduleService(FlightScheduleService flightScheduleService) {
        this.flightScheduleService = flightScheduleService;
    }

    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @Autowired
    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
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
        if (bookTicket.getDate() != null && bookTicket.getDate().compareTo(LocalDate.now()) < 0) {
            bindingResult.rejectValue("date", "error.bookTicket.date.past");
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
    public ModelAndView modelAndView(
            @PathVariable("flightScheduleId") Integer flightScheduleId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @ModelAttribute("passengerSeats") PassengerSeats passengerSeats,
            ModelAndView modelAndView,
            HttpServletRequest request
    ) {
        User user = (User) request.getSession().getAttribute("user");
        FlightSchedule flightSchedule = flightScheduleService.getFlightScheduleById(flightScheduleId);
        Flight flight = flightService.getFlightByNo(flightSchedule.getFlightNo());

        // Todo: Check in the database if there is any flight with same details present in the database
        // If so then update the seats number according to it

        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setFlightSchedule(flightSchedule);
        ticket.setFlight(flight);
        ticket.setDate(date);
        // Todo: Make sure to deal with it later
        ticket.setEconomySeatsAvailable(flight.getEconomySeats());
        ticket.setBusinessSeatsAvailable(flight.getBusinessSeats());
        ticket.setPassengerSeats(passengerSeats);
        // Todo: Also don't forget about his
        ticket.setFlightIsScheduled(false);

        request.getSession().setAttribute("ticket", ticket);

        modelAndView.addObject("flightScheduleId", flightScheduleId);
        modelAndView.setViewName("user/user_home/book_ticket/book-flight");

        return modelAndView;
    }

    @PostMapping("/user/user-home/book-ticket/book-flight/{flightScheduleId}")
    public ModelAndView modelAndView(
            @PathVariable("flightScheduleId") Integer flightScheduleId,
            @ModelAttribute("passengerSeats") PassengerSeats passengerSeats,
            ModelAndView modelAndView,
            BindingResult bindingResult,
            HttpServletRequest request
    ) {
        // Todo: Validate seat numbers

//        modelAndView.setViewName(String.format("user/user_home/book_ticket/book-flight/%d", flightScheduleId));
        modelAndView.setViewName("redirect:/user/user-home/book-ticket/passenger-entry");

        return modelAndView;
    }

    @GetMapping("/user/user-home/book-ticket/passenger-entry")
    public ModelAndView passengerSeats(
            ModelAndView modelAndView,
            BindingResult bindingResult,
            HttpServletRequest request
    ) {
//        Ticket ticket = (Ticket) request.getSession().getAttribute("ticket");
//
//        modelAndView.addObject("totalPassenger", ticket.getPassengerSeats().getTotalPassengerCount());
        modelAndView.addObject("totalPassenger", 1);
        modelAndView.setViewName("user/user_home/book_ticket/passenger-entry");

        return modelAndView;
    }

    @PostMapping("/user/user-home/book-ticket/passenger-entry")
    public void passengersDetails(
            @RequestBody List<Passenger> passengers
    ) {
        System.out.println(passengers);
    }

    @GetMapping("/user/user-home/book-ticket/booking-details")
    public ModelAndView bookingDetails() {
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
