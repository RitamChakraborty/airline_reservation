package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.User;
import com.cognizant.airline_ticket_reservation_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
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
}
