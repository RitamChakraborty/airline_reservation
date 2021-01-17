package com.cognizant.airline_ticket_reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
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
    public String userDetails() {
        return "user-details";
    }
}
