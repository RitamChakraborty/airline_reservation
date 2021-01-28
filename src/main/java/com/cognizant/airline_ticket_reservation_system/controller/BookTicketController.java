package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.*;
import com.cognizant.airline_ticket_reservation_system.service.FlightScheduleService;
import com.cognizant.airline_ticket_reservation_system.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    public void setFlightScheduleService(FlightScheduleService flightScheduleService) {
        this.flightScheduleService = flightScheduleService;
    }

    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
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
            @ModelAttribute("passengerSeats") PassengerSeats passengerSeats,
            ModelAndView modelAndView,
            HttpServletRequest request
    ) {
        FlightSchedule flightSchedule = flightScheduleService.getFlightScheduleById(flightScheduleId);
        flightSchedule.setFlight(flightService.getFlightByNo(flightSchedule.getFlightNo()));
        modelAndView.setViewName("user/user_home/book_ticket/book-flight");
        request.getSession().setAttribute("flightSchedule", flightSchedule);

        return modelAndView;
    }

    @PostMapping("/user/user-home/book-ticket/passenger-entry")
    public ModelAndView passengerSeats(
            @ModelAttribute("passengerSeats") PassengerSeats passengerSeats,
            ModelAndView modelAndView,
            BindingResult bindingResult
    ) {
        modelAndView.addObject("totalPassenger", passengerSeats.getTotalPassengerCount());
        modelAndView.setViewName("user/user_home/book_ticket/book_flight/passenger-entry");

        return modelAndView;
    }

    @PostMapping("/user/user-home/book-ticket/passengers-details")
    public ModelAndView passengersDetails(
            @RequestBody List<Passenger> passengers
    ) {
        System.out.println(passengers);
        return new ModelAndView("user/user_home/book_ticket/book_flight/passenger-entry");
    }

    @GetMapping("/user/user-home/book-ticket/payment")
    public ModelAndView payment(
            // Todo: 9.2. Also add the same annotation here also, because you know ...
    ) {
        return new ModelAndView("user/user_home/book_ticket/payment");
    }

    // Todo: 8. Add appropriate annotation for post mapping
    public ModelAndView payment(
            // Todo: 9.1. Add model attributes to get the input
            ModelAndView modelAndView,
            HttpServletRequest request
    ) {
        // You can get the cost from the flightSchedule object
        FlightSchedule flightSchedule = (FlightSchedule) request.getSession().getAttribute("flightSchedule");

        // Todo: 12. Validate the inputs, don't forget about insufficient balance, and that error message will again be taken from message.properties file
        // Todo: 13. If validations pass reduce the balance in Account class
        // Todo: 14. Save value in database

        // The page will redirected to payment-successful page if everything go on correctly
        modelAndView.setViewName("redirect:/user/user-home/book-ticket/payment-successful");

        // Best of luck, here is something which will give you energy to push it through, 🍰

        return modelAndView;
    }


    @GetMapping("/user/user-home/book-ticket/payment-successful")
    public ModelAndView paymentSuccessful() {
        return new ModelAndView("user/user_home/book_ticket/payment-successful");
    }

    @ModelAttribute("sources")
    private List<String> sources(@Value("#{'${flightSchedule.sources}'.split(',')}") List<String> sources) {
        return sources;
    }

    @ModelAttribute("destinations")
    private List<String> destinations(@Value("#{'${flightSchedule.destinations}'.split(',')}") List<String> destinations) {
        return destinations;
    }

    // Todo: 4. create function which will get the bank name from database
    // use correct annotation
    // the function will return a Map of banks, where bank id is the key and bank name is the value

    // Todo: 7. Add insert queries inside data.sql file to insert some banks in the database
}
