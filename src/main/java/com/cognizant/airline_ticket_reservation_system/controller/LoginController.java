package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.Admin;
import com.cognizant.airline_ticket_reservation_system.model.RoleSelection;
import com.cognizant.airline_ticket_reservation_system.model.User;
import com.cognizant.airline_ticket_reservation_system.model.UserLogin;
import com.cognizant.airline_ticket_reservation_system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LoginController {
    private LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
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
    public String adminHome(
            @Valid @ModelAttribute("admin") Admin admin,
            BindingResult bindingResult,
            ModelMap modelMap,
            @Value("${error.admin.invalidCredentials}") String errorMessage
    ) {
        if (bindingResult.hasErrors()) {
            return "admin-login";
        }

        boolean validAdmin = loginService.validAdmin(admin);

        if (validAdmin) {
            return "admin-home";
        } else {
            modelMap.addAttribute("errorMessage", errorMessage);
            return "admin-login";
        }
    }

    @GetMapping("/user-login")
    public String userLogin(@ModelAttribute("userLogin") UserLogin userLogin) {
        return "user-login";
    }

    @PostMapping("/user-home")
    public String userHome(
            @Valid @ModelAttribute("userLogin") UserLogin userLogin,
            BindingResult bindingResult,
            ModelMap modelMap,
            @Value("${error.admin.invalidCredentials}") String errorMessage
    ) {
        if (bindingResult.hasErrors()) {
            return "user-login";
        }

        User user = loginService.validateUser(userLogin);

        if (user == null) {
            modelMap.addAttribute("errorMessage", errorMessage);
            return "user-login";
        } else {
            System.out.println(user);
            return "user-home";
        }
    }
}
