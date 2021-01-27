package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.Admin;
import com.cognizant.airline_ticket_reservation_system.model.NewsFeed;
import com.cognizant.airline_ticket_reservation_system.model.RoleSelection;
import com.cognizant.airline_ticket_reservation_system.model.UserLogin;
import com.cognizant.airline_ticket_reservation_system.service.NewsFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private NewsFeedService newsFeedService;

    @Autowired
    public void setNewsFeedService(NewsFeedService newsFeedService) {
        this.newsFeedService = newsFeedService;
    }

    @GetMapping("/")
    public ModelAndView roleSelect(
            @ModelAttribute("roleSelection") RoleSelection roleSelection,
            @ModelAttribute("admin") Admin admin,
            @ModelAttribute("userLogin") UserLogin userLogin
    ) {
        return new ModelAndView("role-select");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return new ModelAndView("logout");
    }

    @ModelAttribute("roles")
    public List<String> populateRoles(@Value("#{'${label.selectRole.category}'.split(',')}") List<String> roles) {
        return roles;
    }

    @ModelAttribute("newsFeeds")
    public List<NewsFeed> newsFeeds() {
        return newsFeedService.getNewsFeeds()
                .stream()
                .filter(newsFeed -> newsFeed.getDate().compareTo(LocalDate.now()) >= 0)
                .collect(Collectors.toList());
    }
}
