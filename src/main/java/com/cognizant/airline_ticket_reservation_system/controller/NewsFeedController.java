package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.NewsFeed;
import com.cognizant.airline_ticket_reservation_system.service.NewsFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/add-news")
    public String addNews(
            @RequestParam("username") String username,
            @ModelAttribute("newsFeed") NewsFeed newsFeed
    ) {
        return "add-news";
    }

    @PostMapping("/add-news")
    public String addNews(
            @RequestParam("username") String username,
            @Valid @ModelAttribute("newsFeed") NewsFeed newsFeed,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "add-news";
        }

        newsFeedService.saveNewsFeed(newsFeed);

        return "redirect:/add-news?username=" + username;
    }

    @ModelAttribute("newsFeeds")
    public List<NewsFeed> newsFeeds() {
        return newsFeedService.getNewsFeeds()
                .stream()
                .sorted((n1, n2) -> -n1.getDate().compareTo(n2.getDate()))
                .collect(Collectors.toList());
    }
}
