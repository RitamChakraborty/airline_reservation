package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.User;
import com.cognizant.airline_ticket_reservation_system.model.UserDetailsUpdate;
import com.cognizant.airline_ticket_reservation_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user-home")
    public String userHomePost() {
        return "user-home";
    }

    @GetMapping("/user-home")
    public String userHome(@RequestParam("id") Integer id, ModelMap modelMap) {
        User user = userService.getUserById(id);
        modelMap.addAttribute("user", user);

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
    public String viewProfile(@RequestParam("id") Integer id, ModelMap modelMap) {
        User user = userService.getUserById(id);
        modelMap.addAttribute("user", user);

        return "user-profile";
    }

    @GetMapping("/update-details")
    public String updateDetails(
            @RequestParam("id") Integer id,
            @ModelAttribute("userDetailsUpdate") UserDetailsUpdate userDetailsUpdate,
            ModelMap modelMap
    ) {
        User user = userService.getUserById(id);
        modelMap.addAttribute("user", user);

        return "update-details";
    }

    @PostMapping("/update-details")
    public String updateDetailsPost(
            @RequestParam("id") Integer id,
            @Valid @ModelAttribute("userDetailsUpdate") UserDetailsUpdate userDetailsUpdate,
            BindingResult bindingResult,
            ModelMap modelMap
    ) {
        if (bindingResult.hasErrors()) {
            return "update-details";
        }

        User user = new User();
        user.setId(id);
        user.setName(userDetailsUpdate.getName());
        user.setEmail(userDetailsUpdate.getEmail());
        user.setAddress(userDetailsUpdate.getAddress());
        user.setPhone(userDetailsUpdate.getPhone());

        // Todo: Verify that updated user has some changes

        userService.updateUserById(user);

        return "redirect:/user-home?id=" + id;
    }

    @GetMapping("/change-password")
    public String changePassword() {
        return "change-password";
    }
}
