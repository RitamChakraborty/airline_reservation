package com.cognizant.airline_ticket_reservation_system.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class FlightScheduleController {
    private FlightService flightService;
    private FlightScheduleService flightScheduleService;

    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @Autowired
    public void setFlightScheduleService(FlightScheduleService flightScheduleService) {
        this.flightScheduleService = flightScheduleService;
    }

    @GetMapping("/admin/admin-home/schedule-flight")
    public ModelAndView scheduleFlight() {
        return new ModelAndView("admin/admin_home/schedule-flight");
    }

    @GetMapping("/admin/admin-home/schedule-flight/add-schedule")
    public ModelAndView addSchedule(
            @RequestParam("no") Integer flightNo,
            @ModelAttribute("flightSchedule") FlightSchedule flightSchedule,
            ModelAndView modelAndView
    ) {
        Flight flight = flightService.getFlightByNo(flightNo);

        modelAndView.addObject("flight", flight);
        modelAndView.setViewName("admin/admin_home/schedule_flight/add-schedule");

        return modelAndView;
    }

    @PostMapping("/admin/admin-home/schedule-flight/add-schedule")
    public ModelAndView addSchedule(
            @RequestParam("no") Integer flightNo,
            @Valid @ModelAttribute("flightSchedule") FlightSchedule flightSchedule,
            BindingResult bindingResult
    ) {
        // Check if departure time is equal or before arrival time
        if (flightSchedule.getArrivalTime() != null && flightSchedule.getDepartureTime() != null) {
            if (flightSchedule.getArrivalTime().compareTo(flightSchedule.getDepartureTime()) >= 0) {
                bindingResult.rejectValue("departureTime", "error.flightSchedule.departureTime.equalOrBeforeArrival");
            }
        }

        // Check if source and destination are same
        if (
                flightSchedule.getSource() != null &&
                        flightSchedule.getDestination() != null &&
                        flightSchedule.getSource().equals(flightSchedule.getDestination())
        ) {
            bindingResult.rejectValue("destination", "error.flightSchedule.destination.equal");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("admin/admin_home/schedule_flight/add-schedule");
        }

        flightSchedule.setFlightNo(flightNo);
        // Save flight schedule in the database
        flightScheduleService.saveFlightSchedule(flightSchedule);

        return new ModelAndView("redirect:/admin/admin-home/schedule-flight");
    }

    @ModelAttribute("sources")
    private List<String> sources(@Value("#{'${flightSchedule.sources}'.split(',')}") List<String> sources) {
        return sources;
    }

    @ModelAttribute("destinations")
    private List<String> destinations(@Value("#{'${flightSchedule.destinations}'.split(',')}") List<String> destinations) {
        return destinations;
    }

    @ModelAttribute("flights")
    public List<Flight> flights() {
        return flightService.getFlights();
    }

    @ModelAttribute("flightSchedules")
    public List<FlightSchedule> flightSchedules() {
        return flightScheduleService.getFlightSchedules();
    }
}
