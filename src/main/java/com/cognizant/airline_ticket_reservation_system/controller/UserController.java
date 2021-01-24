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

    @PostMapping("/user/user-login")
    public ModelAndView userLogin(
            @Valid @ModelAttribute("userLogin") UserLogin userLogin,
            BindingResult bindingResult,
            ModelAndView modelAndView,
            HttpServletRequest request,
            @Value("${error.admin.invalidCredentials}") String errorMessage
    ) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("user/user-login");
            return modelAndView;
        }

        User user = userService.getValidateUser(userLogin);

        if (user == null) {
            System.out.println(errorMessage);
            modelAndView.addObject("errorMessage", errorMessage);
            modelAndView.setViewName("user/user-login");

            return modelAndView;
        }

        request.getSession().setAttribute("user", user);
        modelAndView.setViewName("redirect:/user/user-home");

        return modelAndView;
    }

    @GetMapping("/user/user-registration")
    public ModelAndView userRegistration(@ModelAttribute("userRegistration") UserRegistration userRegistration) {
        return new ModelAndView("user/user-registration");
    }

    @PostMapping("user/user-registration")
    public ModelAndView userRegistration(
            @Valid @ModelAttribute("userRegistration") UserRegistration userRegistration,
            BindingResult bindingResult,
            ModelAndView modelAndView,
            HttpServletRequest request,
            @Value("${error.user.confirmPassword.notEqual}") String errorMessage
    ) {
        if (userRegistration.getPassword() != null && userRegistration.getConfirmPassword() != null) {
            if (!userRegistration.getPassword().equals(userRegistration.getConfirmPassword())) {
                bindingResult.rejectValue("confirmPassword", "error.user.confirmPassword.notEqual");
            }
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("user/user-registration");
            return modelAndView;
        }

        User newUser = new User();
        newUser.setName(userRegistration.getName());
        newUser.setPassword(userRegistration.getPassword());
        newUser.setAge(userRegistration.getAge());
        newUser.setGender(userRegistration.getGender());
        newUser.setEmail(userRegistration.getEmail());
        newUser.setAddress(userRegistration.getAddress());
        newUser.setPhone(userRegistration.getPhone());
        newUser.setSecretQuestion(userRegistration.getSecretQuestion());
        newUser.setAnswer(userRegistration.getAnswer().toLowerCase());

        // Save new user in database
        userService.saveUser(newUser);
        // Get the user id of the last user added
        Integer userId = userService.getLastUsersId();

        newUser.setId(userId);
        request.getSession().setAttribute("user", newUser);
        modelAndView.setViewName(
                String.format("redirect:/user/user-home?msg=%s",
                        String.format("Registration complete. Your user id is %d", userId))
        );

        return modelAndView;
    }

    @GetMapping("user/forget-password")
    public ModelAndView forgetPassword(@ModelAttribute("userForgetPassword") UserForgetPassword userForgetPassword) {
        return new ModelAndView("user/forget-password");
    }

    @PostMapping("user/forget-password")
    public ModelAndView forgetPassword(
            @Valid @ModelAttribute("userForgetPassword") UserForgetPassword userForgetPassword,
            BindingResult bindingResult,
            ModelAndView modelAndView,
            HttpServletRequest request,
            @Value("${user.updatePasswordSuccessfully}") String message
    ) {
        System.out.println(userForgetPassword);

        if (userForgetPassword.getId() != null) {
            User user = userService.getUserById(userForgetPassword.getId());

            if (user == null) {
                // User id does not exists
                bindingResult.rejectValue("id", "error.user.id.notExists");
            } else {
                if (
                        !userForgetPassword.getAnswer().isBlank() &&
                                !userForgetPassword.getSecretQuestion().isBlank() &&
                                !userForgetPassword.getAnswer().isBlank() &&
                                !userForgetPassword.getEmail().isBlank() &&
                                !userForgetPassword.getPhone().isBlank() &&
                                !userForgetPassword.getNewPassword().isBlank() &&
                                !userForgetPassword.getConfirmPassword().isBlank()
                ) {
                    if (!userForgetPassword.getSecretQuestion().equals(user.getSecretQuestion())) {
                        // Secret question does not match
                        bindingResult.rejectValue("secretQuestion", "error.user.secretQuestion.noMatch");
                    } else {
                        if (!userForgetPassword.getAnswer().toLowerCase().equals(user.getAnswer())) {
                            // Answer does not match
                            bindingResult.rejectValue("answer", "error.user.answer.noMatch");
                        }
                    }

                    if (!userForgetPassword.getEmail().equals(user.getEmail())) {
                        // Email does not match
                        bindingResult.rejectValue("email", "error.user.email.noMatch");
                    }

                    if (!userForgetPassword.getPhone().equals(user.getPhone())) {
                        // Phone no does not match
                        bindingResult.rejectValue("phone", "error.user.phone.noMatch");
                    }

                    if (userForgetPassword.getNewPassword().equals(user.getPassword())) {
                        // New password is equal to the old one
                        bindingResult.rejectValue("newPassword", "error.user.newPassword.equalsOld");
                    }

                    if (!userForgetPassword.getNewPassword().equals(userForgetPassword.getConfirmPassword())) {
                        // New password and confirm password do not match
                        bindingResult.rejectValue("confirmPassword", "error.user.confirmPassword.notEqual");
                    }
                }
            }
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("user/forget-password");
            return modelAndView;
        }

        User user = userService.getUserById(userForgetPassword.getId());
        user.setPassword(userForgetPassword.getNewPassword());

        // Save updated user in database
        userService.updateUser(user);

        // Reset session value
        request.getSession().removeAttribute("user");
        request.getSession().setAttribute("user", user);

        modelAndView.setViewName(String.format("redirect:/user/user-home?msg=%s", message));

        return modelAndView;
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

    @ModelAttribute("genders")
    public List<String> genders(@Value("#{'${user.genders}'.split(',')}") List<String> genders) {
        return genders;
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
