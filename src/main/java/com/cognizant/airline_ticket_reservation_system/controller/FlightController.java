package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.Flight;
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
public class FlightController {
    private FlightService flightService;

    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/admin/admin-home/manage-flight")
    public ModelAndView manageFlight(@RequestParam(value = "msg", required = false) String message, ModelAndView modelAndView) {
        // Get flight from the database
        List<Flight> flights = flightService.getFlights();
        modelAndView.addObject("flights", flights);
        modelAndView.addObject("msg", message);
        modelAndView.setViewName("admin/admin_home/manage-flight");

        return modelAndView;
    }

    @GetMapping("/admin/admin-home/manage-flight/add-flight")
    public ModelAndView addFlight(@ModelAttribute("flight") Flight flight) {
        return new ModelAndView("admin/admin_home/manage_flight/add-flight");
    }

    @PostMapping("/admin/admin-home/manage-flight/add-flight")
    public ModelAndView addFlight(
            @Valid @ModelAttribute("flight") Flight flight,
            BindingResult bindingResult,
            ModelAndView modelAndView,
            @Value("${flight.additionSuccessful}") String message
    ) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("admin/admin_home/manage_flight/add-flight");
            return modelAndView;
        }

        // Save new flight in the database
        flightService.addFlight(flight);
        modelAndView.setViewName(String.format("redirect:/admin/admin-home/manage-flight?msg=%s", message));

        return modelAndView;
    }

    @GetMapping("/admin/admin-home/manage-flight/update-flight")
    public ModelAndView updateFlight(
            @RequestParam("no") Integer no,
            @ModelAttribute("flight") Flight flight,
            ModelAndView modelAndView
    ) {
        // Get flight from database by flight no
        Flight flightFromDatabase = flightService.getFlightByNo(no);
        modelAndView.addObject("flight", flightFromDatabase);
        modelAndView.setViewName("admin/admin_home/manage_flight/update-flight");

        return modelAndView;
    }

    @PostMapping("/admin/admin-home/manage-flight/update-flight")
    public ModelAndView updateFlight(
            @RequestParam("no") Integer no,
            @Valid @ModelAttribute("flight") Flight flight,
            BindingResult bindingResult,
            ModelAndView modelAndView,
            @Value("${flight.updateSuccessful}") String message
    ) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("admin/admin_home/manage_flight/update-flight");
            return modelAndView;
        }

        flight.setNo(no);
        // Update flight in the database
        flightService.updateFlight(flight);
        modelAndView.setViewName(String.format("redirect:/admin/admin-home/manage-flight?msg=%s", message));

        return modelAndView;
    }

    @GetMapping("/admin/admin-home/manage-flight/delete-flight")
    public ModelAndView deleteFlight(
            @RequestParam("no") Integer no,
            ModelAndView modelAndView
    ) {
        // Get flight from the database
        Flight flight = flightService.getFlightByNo(no);
        modelAndView.addObject("flight", flight);
        modelAndView.setViewName("admin/admin_home/manage_flight/delete-flight");

        return modelAndView;
    }

    @PostMapping("/admin/admin-home/manage-flight/delete-flight")
    public ModelAndView deleteFlight(
            @RequestParam("no") Integer no,
            ModelAndView modelAndView,
            @Value("${flight.deleteSuccessful}") String message
    ) {
        // Delete flight from the database
        flightService.deleteFlightByNo(no);
        modelAndView.setViewName(String.format("redirect:/admin/admin-home/manage-flight?msg=%s", message));

        return modelAndView;
    }

    @ModelAttribute("airlines")
    public List<String> airlines(@Value("#{'${flight.airline}'.split(',')}") List<String> airlines) {
        return airlines;
    }

    @ModelAttribute("models")
    public List<String> models(@Value("#{'${flight.model}'.split(',')}") List<String> models) {
        return models;
    }

    @ModelAttribute("types")
    public List<String> types(@Value("#{'${flight.type}'.split(',')}") List<String> types) {
        return types;
    }
}
