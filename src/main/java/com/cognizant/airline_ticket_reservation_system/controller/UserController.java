package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.User;
import com.cognizant.airline_ticket_reservation_system.model.UserRegistration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@PropertySource("classpath:messages.properties")
public class UserController {
    @GetMapping("/user-registration")
    public String userRegistration(@ModelAttribute("userRegistration") UserRegistration userRegistration) {
        return "user-registration";
    }

    @PostMapping("/user-singup")
    public String userSignup(
            @Valid @ModelAttribute("userRegistration") UserRegistration userRegistration,
            BindingResult bindingResult,
            ModelMap modelMap,
            @Value("${error.user.confirmPassword.notEqual}") String errorMessage
    ) {
        if (bindingResult.hasErrors()) {
            return "user-registration";
        } else if (!userRegistration.getPassword().equals(userRegistration.getConfirmPassword())) {
            modelMap.addAttribute("errorMessage", errorMessage);
            return "user-registration";
        }

        User user = new User();
        user.setName(userRegistration.getName());
        user.setPassword(userRegistration.getPassword());
        user.setEmail(userRegistration.getEmail());
        user.setAddress(userRegistration.getAddress());
        user.setPhone(userRegistration.getPhone());

        System.out.println(user);

        return "user-home";
    }
}
