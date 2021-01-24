package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.RoleSelection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @GetMapping("/login")
    public ModelAndView login(@ModelAttribute("roleSelection") RoleSelection roleSelection) {
        String role = roleSelection.getRole();

        switch (role) {
            case "Admin": {
                return new ModelAndView("redirect:/admin/admin-login");
            }
            case "User": {
                return new ModelAndView("redirect:/user/user-login");
            }
            default: {
                return new ModelAndView("error");
            }
        }
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return new ModelAndView("logout");
    }
}
