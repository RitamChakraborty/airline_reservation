package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.*;
import com.cognizant.airline_ticket_reservation_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    private NewsFeedService newsFeedService;
    private FlightService flightService;
    private FlightScheduleService flightScheduleService;
    private FlightBookingService flightBookingService;
    private BookingService bookingService;
    private PassengerService passengerService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setNewsFeedService(NewsFeedService newsFeedService) {
        this.newsFeedService = newsFeedService;
    }

    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @Autowired
    public void setFlightScheduleService(FlightScheduleService flightScheduleService) {
        this.flightScheduleService = flightScheduleService;
    }

    @Autowired
    public void setFlightBookingService(FlightBookingService flightBookingService) {
        this.flightBookingService = flightBookingService;
    }

    @Autowired
    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Autowired
    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
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
            @Value("${user.updatePasswordSuccessful}") String message
    ) {
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

    @GetMapping("/user/user-home/history")
    public ModelAndView history(
            ModelAndView modelAndView,
            HttpServletRequest request
    ) {
        User user = (User) request.getSession().getAttribute("user");

        List<Booking> bookings = bookingService.getBookingsByUserId(user.getId());

        modelAndView.addObject("bookings", bookings);
        modelAndView.setViewName("/user/user_home/history");

        return modelAndView;
    }

    @GetMapping("/user/user-home/history/view-booking/{bookingId}/{flightBookingId}")
    public ModelAndView viewBooking(
            @PathVariable("bookingId") String bookingId,
            @PathVariable("flightBookingId") String flightBookingId,
            ModelAndView modelAndView
    ) {
        FlightBooking flightBooking = flightBookingService.getFlightBookingByFlightBookingId(flightBookingId);
        FlightSchedule flightSchedule = flightScheduleService.getFlightScheduleById(flightBooking.getScheduledFlightId());
        Flight flight = flightService.getFlightByNo(flightSchedule.getFlightNo());
        List<Passenger> passengers = passengerService.getPassengersByBookingId(bookingId);

        modelAndView.addObject("flightBooking", flightBooking);
        modelAndView.addObject("flightSchedule", flightSchedule);
        modelAndView.addObject("flight", flight);
        modelAndView.addObject("passengers", passengers);
        modelAndView.setViewName("user/user_home/history/view-booking");

        return modelAndView;
    }

    @GetMapping("/user/user-home/view-profile")
    public ModelAndView viewProfile(@RequestParam(value = "msg", required = false) String message, ModelAndView modelAndView) {
        if (message != null) {
            modelAndView.addObject("msg", message);
        }

        modelAndView.setViewName("user/user_home/view-profile");

        return modelAndView;
    }

    @GetMapping("/user/user-home/view-profile/update-details")
    public ModelAndView updateDetails(@ModelAttribute("user") User user) {
        return new ModelAndView("user/user_home/view_profile/update-details");
    }

    @PostMapping("/user/user-home/view-profile/update-details")
    public ModelAndView updateDetails(
            @Valid @ModelAttribute("user") User updatedUser,
            BindingResult bindingResult,
            ModelAndView modelAndView,
            HttpServletRequest request,
            @Value("${user.updateSuccessful}") String message
    ) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("user/user_home/view_profile/update-details");
            return modelAndView;
        }

        User user = (User) request.getSession().getAttribute("user");

        if (
                updatedUser.getName().equals(user.getName()) &&
                        updatedUser.getAge().equals(user.getAge()) &&
                        updatedUser.getGender().equals(user.getGender()) &&
                        updatedUser.getEmail().equals(user.getEmail()) &&
                        updatedUser.getAddress().equals(user.getAddress()) &&
                        updatedUser.getPhone().equals(user.getPhone())
        ) {
            modelAndView.addObject("message", "No changes found");
            modelAndView.setViewName("user/user_home/view_profile/update-details");

            return modelAndView;
        }

        // Set changed value the user object
        user.setName(updatedUser.getName());
        user.setAge(updatedUser.getAge());
        user.setGender(updatedUser.getGender());
        user.setEmail(updatedUser.getEmail());
        user.setAddress(updatedUser.getAddress());
        user.setPhone(updatedUser.getPhone());
        // Save updated user in database
        userService.updateUser(user);
        // Change session attribute
        request.getSession().removeAttribute("user");
        request.getSession().setAttribute("user", user);

        modelAndView.setViewName(String.format("redirect:/user/user-home/view-profile?msg=%s", message));

        return modelAndView;
    }

    @GetMapping("/user/user-home/view-profile/change-password")
    public ModelAndView changePassword(
            @ModelAttribute("userChangePassword") UserChangePassword userChangePassword,
            ModelAndView modelAndView
    ) {
        modelAndView.setViewName("user/user_home/view_profile/change-password");
        return modelAndView;
    }

    @PostMapping("/user/user-home/view-profile/change-password")
    public ModelAndView changePassword(
            @Valid @ModelAttribute("userChangePassword") UserChangePassword userChangePassword,
            BindingResult bindingResult,
            ModelAndView modelAndView,
            HttpServletRequest request,
            @Value("${user.updatePasswordSuccessful}") String message
    ) {
        User user = (User) request.getSession().getAttribute("user");

        if (
                userChangePassword.getPreviousPassword() != null &&
                        userChangePassword.getNewPassword() != null &&
                        userChangePassword.getConfirmPassword() != null
        ) {
            if (!userChangePassword.getPreviousPassword().equals(user.getPassword())) {
                bindingResult.rejectValue("previousPassword", "error.userChangePassword.previousPassword.notEquals");
            }
            if (userChangePassword.getNewPassword().equals(user.getPassword())) {
                bindingResult.rejectValue("newPassword", "error.userChangePassword.newPassword.equalsOld");
            } else {
                if (!userChangePassword.getNewPassword().equals(userChangePassword.getConfirmPassword())) {
                    bindingResult.rejectValue("confirmPassword", "error.userChangePassword.confirmPassword.notEquals");
                }
            }
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("user/user_home/view_profile/change-password");
            return modelAndView;
        }

        // Change password of the user object
        user.setPassword(userChangePassword.getNewPassword());
        // Save updated user in the database
        userService.updateUser(user);
        // Change session attribute
        request.getSession().removeAttribute("user");
        request.getSession().setAttribute("user", user);
        modelAndView.setViewName(String.format("redirect:/user/user-home/view-profile?msg=%s", message));

        return modelAndView;
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
