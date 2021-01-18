package com.cognizant.airline_ticket_reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
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
}
