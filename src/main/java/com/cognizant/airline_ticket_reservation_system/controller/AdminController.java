package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.Flight;
import com.cognizant.airline_ticket_reservation_system.model.User;
import com.cognizant.airline_ticket_reservation_system.service.FlightService;
import com.cognizant.airline_ticket_reservation_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {
    private UserService userService;
    private FlightService flightService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/manage-flight")
    public String manageFlight() {
        return "manage-flight";
    }

    @GetMapping("/schedule-flight")
    public String scheduleFlight() {
        return "schedule-flight";
    }

    @GetMapping("/booking-details")
    public String bookingDetails() {
        return "booking-details";
    }

    @GetMapping("/user-details")
    public String userDetails(ModelMap modelMap) {
        List<User> userList = userService.getUsers();
        modelMap.addAttribute("userList", userList);

        return "user-details";
    }

    @GetMapping("/add-flight")
    public String addFlight(@ModelAttribute("flight") Flight flight) {
        return "add-flight";
    }

    @PostMapping("/add-flight")
    public String addFlightPost(
            @ModelAttribute("flight") Flight flight,
            BindingResult bindingResult,
            ModelMap modelMap
    ) {
        flightService.addFlight(flight);
        return "redirect:/manage-flight";
    }
}
