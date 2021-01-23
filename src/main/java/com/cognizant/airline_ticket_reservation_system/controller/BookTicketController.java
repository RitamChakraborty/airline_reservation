package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.Flight;
import com.cognizant.airline_ticket_reservation_system.model.FlightSchedule;
import com.cognizant.airline_ticket_reservation_system.model.FlightSearch;
import com.cognizant.airline_ticket_reservation_system.service.FlightScheduleService;
import com.cognizant.airline_ticket_reservation_system.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class BookTicketController {
    private FlightScheduleService flightScheduleService;
    private FlightService flightService;

    @Autowired
    public void setFlightScheduleService(FlightScheduleService flightScheduleService) {
        this.flightScheduleService = flightScheduleService;
    }

    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
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
        if (flightSearch.getDate() != null && flightSearch.getDate().compareTo(LocalDate.now()) < 0) {
            bindingResult.rejectValue("date", "error.flightSearch.date.past");
        }

        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("showFlight", false);
            return "flight-search";
        }

        modelMap.addAttribute("showFlight", true);

        List<FlightSchedule> flightSchedules = flightScheduleService.getFlightSchedulesByDateSourceDestination(flightSearch);

        for (FlightSchedule flightSchedule : flightSchedules) {
            Flight flight = flightService.getFlightByNo(flightSchedule.getFlightNo());
            flightSchedule.setFlight(flight);
        }

        if (!flightSchedules.isEmpty()) {
            modelMap.addAttribute("flightsFound", true);
            modelMap.addAttribute("flightSchedules", flightSchedules);
        }

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
