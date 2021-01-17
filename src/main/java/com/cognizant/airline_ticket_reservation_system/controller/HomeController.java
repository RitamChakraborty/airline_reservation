package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.RoleSelection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String roleSelect(@ModelAttribute("roleSelection") RoleSelection roleSelection) {
        return "role-select";
    }

    @ModelAttribute("roles")
    public List<String> populateRoles(@Value("#{'${label.selectRole.category}'.split(',')}") List<String> roles) {
        return roles;
    }
}
