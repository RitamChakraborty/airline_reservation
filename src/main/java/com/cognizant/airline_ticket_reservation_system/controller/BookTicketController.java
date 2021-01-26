package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.BookTicket;
import com.cognizant.airline_ticket_reservation_system.model.Flight;
import com.cognizant.airline_ticket_reservation_system.model.FlightSchedule;
import com.cognizant.airline_ticket_reservation_system.service.FlightScheduleService;
import com.cognizant.airline_ticket_reservation_system.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
            ModelAndView modelAndView,
            HttpServletRequest request
    ) {
        FlightSchedule flightSchedule = flightScheduleService.getFlightScheduleById(flightScheduleId);
        flightSchedule.setFlight(flightService.getFlightByNo(flightSchedule.getFlightNo()));
        modelAndView.setViewName("user/user_home/book_ticket/book-flight");
        request.getSession().setAttribute("flightSchedule", flightSchedule);

        return modelAndView;
    }

    @GetMapping("/user/user-home/book-ticket/payment")
    public ModelAndView payment(HttpServletRequest request) {
        FlightSchedule flightSchedule = (FlightSchedule) request.getSession().getAttribute("flightSchedule");
        return new ModelAndView("user/user_home/book_ticket/payment");
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
}
