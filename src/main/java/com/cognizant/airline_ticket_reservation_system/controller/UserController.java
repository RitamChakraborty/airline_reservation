package com.cognizant.airline_ticket_reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @PostMapping("/user-home")
    public String userHome() {
        return "user-home";
    }

    @GetMapping("/book-ticket")
    public String bookTicket() {
        return "book-ticket";
    }

    @GetMapping("/history")
    public String history() {
        return "history";
    }

    @GetMapping("/view-profile")
    public String viewProfile() {
        return "user-profile";
    }

    @GetMapping("/update-details")
    public String updateDetails() {
        return "update-details";
    }

    @GetMapping("/change-password")
    public String changePassword() {
        return "change-password";
    }
}
