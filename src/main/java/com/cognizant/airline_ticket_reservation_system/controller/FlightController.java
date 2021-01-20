package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.Flight;
import com.cognizant.airline_ticket_reservation_system.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class FlightController {
    private FlightService flightService;

    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/manage-flight")
    public String manageFlight(@RequestParam(value = "msg", required = false) String message, ModelMap modelMap) {
        List<Flight> flights = flightService.getFlights();
        modelMap.addAttribute("flights", flights);

        return "manage-flight";
    }

    @GetMapping("/add-flight")
    public String addFlight(@ModelAttribute("flight") Flight flight) {
        return "add-flight";
    }

    @PostMapping("/add-flight")
    public String addFlightPost(
            @Valid @ModelAttribute("flight") Flight flight,
            BindingResult bindingResult,
            ModelMap modelMap,
            @Value("${flight.additionSuccessful}") String message
    ) {
        if (bindingResult.hasErrors()) {
            return "add-flight";
        }

        flightService.addFlight(flight);
        return "redirect:/manage-flight?msg=" + message;
    }

    @GetMapping("/update-flight")
    public String updateFlight(
            @RequestParam("no") Integer no,
            @ModelAttribute("flight") Flight flight,
            ModelMap modelMap
    ) {
        Flight flightFromDatabase = flightService.getFlightByNo(no);
        modelMap.addAttribute("flight", flightFromDatabase);
        modelMap.addAttribute("no", no);

        return "update-flight";
    }

    @PostMapping("/update-flight")
    public String updateFlight(
            @RequestParam("no") Integer no,
            @Valid @ModelAttribute("flight") Flight flight,
            BindingResult bindingResult,
            ModelMap modelMap,
            @Value("${flight.updateSuccessful}") String message
    ) {
        if (bindingResult.hasErrors()) {
            return "update-flight";
        }

        flight.setNo(no);
        flightService.updateFlight(flight);

        return "redirect:/manage-flight?msg=" + message;
    }

    @GetMapping("/delete-flight")
    public String deleteFlight(
            @RequestParam("no") Integer no,
            ModelMap modelMap
    ) {
        Flight flight = flightService.getFlightByNo(no);
        modelMap.addAttribute("flight", flight);
        modelMap.addAttribute("no", no);

        return "delete-flight";
    }

    @PostMapping("/delete-flight")
    public String deleteFlight(
            @RequestParam("no") Integer no,
            ModelMap modelMap,
            @Value("${flight.deleteSuccessful}") String message
    ) {
        flightService.deleteFlightByNo(no);
        return "redirect:/manage-flight?msg=" + message;
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
