package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.NewsFeed;
import com.cognizant.airline_ticket_reservation_system.model.User;
import com.cognizant.airline_ticket_reservation_system.service.AdminService;
import com.cognizant.airline_ticket_reservation_system.service.NewsFeedService;
import com.cognizant.airline_ticket_reservation_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/admin-home")
    public ModelAndView adminHome() {
        return new ModelAndView("admin/admin-home");
    }

    @GetMapping("/booking-details")
    public String bookingDetails() {
        return "booking-details";
    }

    @GetMapping("/user-details")
    public String userDetails(ModelMap modelMap) {
        List<User> userList = userService.getUsers();
        modelMap.addAttribute("userList", userList);

        return "user-details";
    }

    @ModelAttribute("newsFeeds")
    public List<NewsFeed> newsFeeds() {
        return newsFeedService.getNewsFeeds()
                .stream()
                .filter(newsFeed -> newsFeed.getDate().compareTo(LocalDate.now()) >= 0)
                .collect(Collectors.toList());
    }
}
