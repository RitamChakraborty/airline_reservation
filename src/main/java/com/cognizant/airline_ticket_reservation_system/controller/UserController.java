package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.*;
import com.cognizant.airline_ticket_reservation_system.service.NewsFeedService;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@PropertySource("classpath:messages.properties")
public class UserController {
    private UserService userService;
    private UserChangePasswordValidator userChangePasswordValidator;
    private NewsFeedService newsFeedService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserChangePasswordValidator(UserChangePasswordValidator userChangePasswordValidator) {
        this.userChangePasswordValidator = userChangePasswordValidator;
    }

    @Autowired
    public void setNewsFeedService(NewsFeedService newsFeedService) {
        this.newsFeedService = newsFeedService;
    }

    @GetMapping("/user/user-login")
    public ModelAndView userLogin(@ModelAttribute("userLogin") UserLogin userLogin) {
        return new ModelAndView("user/user-login");
    }

    @PostMapping("/user-login")
    public ModelAndView userLogin(
            @Valid @ModelAttribute("userLogin") UserLogin userLogin,
            BindingResult bindingResult,
            ModelAndView modelAndView,
            HttpServletRequest request,
            @Value("${error.admin.invalidCredentials}") String errorMessage
    ) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("user/user-login");
        }

        User user = userService.getValidateUser(userLogin);

        if (user == null) {
            modelAndView.addObject("errorMessage", errorMessage);
            return new ModelAndView("user/user-login");
        }

        request.getSession().setAttribute("user", user);
        modelAndView.setViewName("redirect:/user/user-home");

        return modelAndView;
    }

    @GetMapping("/user-registration")
    public String userRegistration(@ModelAttribute("userRegistration") UserRegistration userRegistration) {
        return "user-registration";
    }

    @PostMapping("/user-singup")
    public String userSignup(
            @Valid @ModelAttribute("userRegistration") UserRegistration userRegistration,
            BindingResult bindingResult,
            ModelMap modelMap,
            HttpServletRequest request,
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
        user.setSecretQuestion(userRegistration.getSecretQuestion());
        user.setAnswer(userRegistration.getAnswer());

        // Save user in database
        userService.saveUser(user);
        request.getSession().setAttribute("user", user);

        return "redirect:/user/user-home";
    }

    @GetMapping("/user/user-home")
    public ModelAndView userHome(
            @RequestParam(value = "msg", required = false) String message,
            ModelAndView modelAndView,
            HttpServletRequest request
    ) {
        User user = (User) request.getSession().getAttribute("user");
        modelAndView.addObject("user", user);
        modelAndView.addObject("msg", message);
        modelAndView.setViewName("user/user-home");

        return modelAndView;
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
            @RequestParam(value = "id", required = false) Integer id,
            @ModelAttribute("userDetailsUpdate") UserDetailsUpdate userDetailsUpdate,
            ModelMap modelMap,
            HttpServletRequest request
    ) {
        User user = (User) request.getSession().getAttribute("user");
        Integer userId = user.getId();
        modelMap.addAttribute("id", userId);
        modelMap.addAttribute("user", user);

        return "update-details";
    }

    @PostMapping("/update-details")
    public String updateDetailsPost(
            @RequestParam(value = "id", required = false) Integer id,
            @Valid @ModelAttribute("userDetailsUpdate") UserDetailsUpdate userDetailsUpdate,
            BindingResult bindingResult,
            ModelMap modelMap,
            HttpServletRequest request,
            @Value("${user.error.noUpdateError}") String noUpdateError,
            @Value("${user.updateSuccessful}") String message
    ) {
        if (bindingResult.hasErrors()) {
            return "update-details";
        }

        User sessionUser = (User) request.getSession().getAttribute("user");
        User updatedUser = new User();
        updatedUser.setId(sessionUser.getId());
        updatedUser.setName(userDetailsUpdate.getName());
        updatedUser.setEmail(userDetailsUpdate.getEmail());
        updatedUser.setAddress(userDetailsUpdate.getAddress());
        updatedUser.setPhone(userDetailsUpdate.getPhone());
        updatedUser.setSecretQuestion(sessionUser.getSecretQuestion());
        updatedUser.setAnswer(sessionUser.getAnswer());

        System.out.println(updatedUser);

        User previousUser = userService.getUserById(id);

        if (previousUser.equals(updatedUser)) {
            modelMap.addAttribute("noUpdateError", noUpdateError);
            return "update-details";
        }

        userService.updateUser(updatedUser);
        request.getSession().removeAttribute("user");
        request.getSession().setAttribute("user", updatedUser);

        return "redirect:/user-home?msg=" + message;
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
            HttpServletRequest request,
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
        request.getSession().removeAttribute("user");
        request.getSession().setAttribute("user", user);

        return "redirect:/user-home?msg=" + message;
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

        return "redirect:/user-home?msg=" + message;
    }

    @ModelAttribute("secretQuestions")
    public List<String> secretQuestions(@Value("#{'${user.secretQuestions}'.split(',')}") List<String> secretQuestions) {
        return secretQuestions;
    }

    @ModelAttribute("newsFeeds")
    public List<NewsFeed> newsFeeds() {
        return newsFeedService.getNewsFeeds()
                .stream()
                .filter(newsFeed -> newsFeed.getDate().compareTo(LocalDate.now()) >= 0)
                .collect(Collectors.toList());
    }
}
