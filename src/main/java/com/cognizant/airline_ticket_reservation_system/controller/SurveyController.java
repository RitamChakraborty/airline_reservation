package com.cognizant.airline_ticket_reservation_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SurveyController {
    @GetMapping("/admin/admin-home/survey")
    public ModelAndView survey() {
        return new ModelAndView("admin/admin_home/survey");
    }

    @GetMapping("/admin/admin-home/survey/create-survey")
    public ModelAndView addSurvey() {
        return new ModelAndView("admin/admin_home/survey/create-survey");
    }
}
