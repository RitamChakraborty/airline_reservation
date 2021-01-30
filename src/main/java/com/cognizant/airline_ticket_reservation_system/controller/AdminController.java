package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.Admin;
import com.cognizant.airline_ticket_reservation_system.model.NewsFeed;
import com.cognizant.airline_ticket_reservation_system.model.User;
import com.cognizant.airline_ticket_reservation_system.service.AdminService;
import com.cognizant.airline_ticket_reservation_system.service.NewsFeedService;
import com.cognizant.airline_ticket_reservation_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AdminController {
    private AdminService adminService;
    private UserService userService;
    private NewsFeedService newsFeedService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @Autowired
    public void setNewsFeedService(NewsFeedService newsFeedService) {
        this.newsFeedService = newsFeedService;
    }

    @GetMapping("/admin/admin-login")
    public ModelAndView adminLogin(@ModelAttribute("admin") Admin admin) {
        return new ModelAndView("admin/admin-login");
    }

    @PostMapping("/admin/admin-login")
    public ModelAndView adminLogin(
            @Valid @ModelAttribute("admin") Admin admin,
            BindingResult bindingResult,
            ModelAndView modelAndView,
            HttpServletRequest request,
            @Value("${error.admin.invalidCredentials}") String errorMessage
    ) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("admin/admin-login");
            return modelAndView;
        }

        // Validating user
        boolean validAdmin = adminService.validAdmin(admin);

        if (!validAdmin) {
            modelAndView.addObject("errorMessage", errorMessage);
            modelAndView.setViewName("admin/admin-login");

            return modelAndView;
        }

        // Setting session attribute
        request.getSession().setAttribute("admin", admin);
        modelAndView.setViewName("redirect:/admin/admin-home");

        return modelAndView;
    }

    @GetMapping("/admin/admin-home")
    public ModelAndView adminHome() {
        return new ModelAndView("admin/admin-home");
    }

    @GetMapping("/admin/admin-home/user-details")
    public ModelAndView userDetails(ModelAndView modelAndView) {
        List<User> userList = userService.getUsers();
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("admin/admin_home/user-details");

        return modelAndView;
    }

    @ModelAttribute("newsFeeds")
    public List<NewsFeed> newsFeeds() {
        return newsFeedService.getNewsFeeds()
                .stream()
                .filter(newsFeed -> newsFeed.getDate().compareTo(LocalDate.now()) >= 0)
                .collect(Collectors.toList());
    }
}
