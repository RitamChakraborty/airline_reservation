package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.User;
import com.cognizant.airline_ticket_reservation_system.model.UserChangePassword;
import com.cognizant.airline_ticket_reservation_system.model.UserDetailsUpdate;
import com.cognizant.airline_ticket_reservation_system.model.UserForgetPassword;
import com.cognizant.airline_ticket_reservation_system.service.UserService;
import com.cognizant.airline_ticket_reservation_system.validator.UserChangePasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@PropertySource("classpath:messages.properties")
public class UserController {
    private UserService userService;
    private UserChangePasswordValidator userChangePasswordValidator;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserChangePasswordValidator(UserChangePasswordValidator userChangePasswordValidator) {
        this.userChangePasswordValidator = userChangePasswordValidator;
    }

    @PostMapping("/user-home")
    public String userHomePost() {
        return "user-home";
    }

    @GetMapping("/user-home")
    public String userHome(
            @RequestParam("id") Integer id,
            @RequestParam(value = "msg", required = false) String message,
            ModelMap modelMap
    ) {
        User user = userService.getUserById(id);
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("msg", message);

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
        modelMap.addAttribute("id", id);
        modelMap.addAttribute("user", user);

        return "update-details";
    }

    @PostMapping("/update-details")
    public String updateDetailsPost(
            @RequestParam("id") Integer id,
            @Valid @ModelAttribute("userDetailsUpdate") UserDetailsUpdate userDetailsUpdate,
            BindingResult bindingResult,
            ModelMap modelMap,
            @Value("${user.error.noUpdateError}") String noUpdateError,
            @Value("${user.updateSuccessful}") String message
    ) {
        modelMap.addAttribute("id", id);

        if (bindingResult.hasErrors()) {
            return "update-details";
        }

        User user = new User();
        user.setId(id);
        user.setName(userDetailsUpdate.getName());
        user.setEmail(userDetailsUpdate.getEmail());
        user.setAddress(userDetailsUpdate.getAddress());
        user.setPhone(userDetailsUpdate.getPhone());

        User previousUser = userService.getUserById(id);

        if (previousUser.equals(user)) {
            modelMap.addAttribute("noUpdateError", noUpdateError);
            return "update-details";
        }

        userService.updateUser(user);

        return "redirect:/user-home?id=" + id + "&msg=" + message;
    }

    @GetMapping("/change-password")
    public String changePassword(
            @RequestParam("id") Integer id,
            @ModelAttribute("userChangePassword") UserChangePassword userChangePassword,
            ModelMap modelMap
    ) {
        modelMap.addAttribute("id", id);
        return "change-password";
    }

    @PostMapping("/change-password")
    public String changePasswordPost(
            @RequestParam("id") Integer id,
            @ModelAttribute("userChangePassword") UserChangePassword userChangePassword,
            BindingResult bindingResult,
            ModelMap modelMap,
            @Value("${user.updatePasswordSuccessfully}") String message
    ) {
        modelMap.addAttribute("id", id);

        User user = userService.getUserById(id);
        String password = user.getPassword();
        String newPassword = userChangePassword.getNewPassword();
        userChangePassword.setOriginalPassword(password);

        userChangePasswordValidator.validate(userChangePassword, bindingResult);

        if (bindingResult.hasErrors()) {
            return "change-password";
        }

        user.setPassword(newPassword);
        userService.updateUser(user);

        return "redirect:/user-home?id=" + id + "&msg=" + message;
    }

    @GetMapping("/forget-password")
    public String changePassword(@ModelAttribute("userForgetPassword") UserForgetPassword userForgetPassword) {
        return "forget-password";
    }

    @PostMapping("/forget-password")
    public String changePasswordPost(
            @Valid @ModelAttribute("userForgetPassword") UserForgetPassword userForgetPassword,
            BindingResult bindingResult,
            ModelMap modelMap,
            @Value("${user.updatePasswordSuccessfully}") String message
    ) {
        Integer id = userForgetPassword.getId();
        if (id != null) {
            User user = userService.getUserById(id);

            if (user == null) {
                bindingResult.rejectValue("id", "error.userForgetPassword.id.notExists");
            }
        }

        String newPassword = userForgetPassword.getNewPassword();
        String confirmPassword = userForgetPassword.getConfirmPassword();

        if (newPassword != null && confirmPassword != null) {
            if (!newPassword.equals(confirmPassword)) {
                bindingResult.rejectValue("confirmPassword", "error.userChangePassword.confirmPassword.notEqual");
            }
        }

        if (bindingResult.hasErrors()) {
            return "forget-password";
        }

        User user = userService.getUserById(id);
        user.setPassword(newPassword);
        userService.updateUser(user);

        return "redirect:/user-home?id=" + id + "&msg=" + message;
    }
}
