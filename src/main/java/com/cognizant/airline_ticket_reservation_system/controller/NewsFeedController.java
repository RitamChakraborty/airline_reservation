package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.NewsFeed;
import com.cognizant.airline_ticket_reservation_system.service.NewsFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class NewsFeedController {
    private NewsFeedService newsFeedService;

    @Autowired
    public void setNewsFeedService(NewsFeedService newsFeedService) {
        this.newsFeedService = newsFeedService;
    }

    @GetMapping("/admin/admin-home/add-news")
    public ModelAndView addNews(
            @ModelAttribute("newsFeed") NewsFeed newsFeed
    ) {
        return new ModelAndView("admin/admin_home/add-news");
    }

    @PostMapping("/admin/admin-home/add-news")
    public ModelAndView addNews(
            @Valid @ModelAttribute("newsFeed") NewsFeed newsFeed,
            BindingResult bindingResult,
            ModelAndView modelAndView
    ) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("admin/admin_home/add-news");
            return modelAndView;
        }

        // Save news in the database
        newsFeedService.saveNewsFeed(newsFeed);
        modelAndView.setViewName("redirect:/admin/admin-home/add-news");

        return modelAndView;
    }

    @ModelAttribute("newsFeeds")
    public List<NewsFeed> newsFeeds() {
        return newsFeedService.getNewsFeeds()
                .stream()
                .sorted((n1, n2) -> -n1.getDate().compareTo(n2.getDate()))
                .collect(Collectors.toList());
    }
}
