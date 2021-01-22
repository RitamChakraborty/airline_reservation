package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.NewsFeed;
import com.cognizant.airline_ticket_reservation_system.service.NewsFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class NewsController {
    private NewsFeedService newsFeedService;

    @Autowired
    public void setNewsFeedService(NewsFeedService newsFeedService) {
        this.newsFeedService = newsFeedService;
    }

    @GetMapping("/add-news")
    public String addNews(@ModelAttribute("newsFeed") NewsFeed newsFeed) {
        return "add-news";
    }

    @PostMapping("/add-news")
    public String addNews(
            @Valid @ModelAttribute("newsFeed") NewsFeed newsFeed,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "add-news";
        }

        newsFeedService.saveNewsFeed(newsFeed);

        return "admin-home";
    }
}
