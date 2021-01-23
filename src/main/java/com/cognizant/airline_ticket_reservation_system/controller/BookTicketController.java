package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.FlightSchedule;
import com.cognizant.airline_ticket_reservation_system.model.FlightSearch;
import com.cognizant.airline_ticket_reservation_system.service.FlightScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookTicketController {
    private FlightScheduleService flightScheduleService;

    @Autowired
    public void setFlightScheduleService(FlightScheduleService flightScheduleService) {
        this.flightScheduleService = flightScheduleService;
    }

    @GetMapping("/flight-search")
    public String flightSearch(
            @ModelAttribute("flightSearch") FlightSearch flightSearch
    ) {
        return "flight-search";
    }

    @PostMapping("/flight-search")
    public String flightSearch(
            @Valid @ModelAttribute("flightSearch") FlightSearch flightSearch,
            BindingResult bindingResult,
            ModelMap modelMap
    ) {
        if (bindingResult.hasErrors()) {
            return "flight-search";
        }

        List<FlightSchedule> flightSchedules = flightScheduleService.getFlightSchedulesByDateSourceDestination(flightSearch);
        System.out.println(flightSchedules);


        return "flight-search";
    }

    @ModelAttribute("sources")
    private List<String> sources(@Value("#{'${flightSchedule.sources}'.split(',')}") List<String> sources) {
        return sources;
    }

    @ModelAttribute("destinations")
    private List<String> destinations(@Value("#{'${flightSchedule.destinations}'.split(',')}") List<String> destinations) {
        return destinations;
    }
}
