package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.Admin;
import com.cognizant.airline_ticket_reservation_system.model.RoleSelection;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class LoginController {
    @GetMapping("/")
    public String roleSelect(@ModelAttribute("roleSelection") RoleSelection roleSelection) {
        return "role-select";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("roleSelection") RoleSelection roleSelection) {
        String role = roleSelection.getRole();

        switch (role) {
            case "Admin": {
                return "redirect:/admin-login";
            }
            case "User": {
                return "redirect:/user-login";
            }
            default: {
                return "error";
            }
        }
    }

    @GetMapping("/admin-login")
    public String adminLogin(@ModelAttribute("admin") Admin admin) {
        return "admin-login";
    }

    @PostMapping("/admin-home")
    public String adminHome(@Valid @ModelAttribute("admin") Admin admin, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin-login";
        }

        // Todo: Validate Admin details

        return "admin-home";
    }

    @ModelAttribute("roles")
    public List<String> populateRoles() {
        return Arrays.asList("Admin", "User");
    }
}
