package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.FlightSearch;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class BookTicketController {
    @GetMapping("/flight-search")
    public String flightSearch(
            @ModelAttribute("flightSearch") FlightSearch flightSearch
    ) {
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
