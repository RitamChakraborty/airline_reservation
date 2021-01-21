package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.Flight;
import com.cognizant.airline_ticket_reservation_system.model.FlightSchedule;
import com.cognizant.airline_ticket_reservation_system.service.FlightScheduleService;
import com.cognizant.airline_ticket_reservation_system.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FlightScheduleController {
    private FlightService flightService;
    private FlightScheduleService flightScheduleService;

    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @Autowired
    public void setFlightScheduleService(FlightScheduleService flightScheduleService) {
        this.flightScheduleService = flightScheduleService;
    }

    @GetMapping("/schedule-flight")
    public String scheduleFlight() {
        return "schedule-flight";
    }

    @GetMapping("/add-schedule")
    public String addSchedule(@ModelAttribute("flightSchedule") FlightSchedule flightSchedule) {
        return "add-schedule";
    }

    @PostMapping("/add-schedule")
    public String addSchedule(
            @Valid @ModelAttribute("flightSchedule") FlightSchedule flightSchedule,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "add-schedule";
        }

        flightScheduleService.saveFlightSchedule(flightSchedule);
        return "redirect:/schedule-flight";
    }

    @ModelAttribute("flights")
    private Map<Integer, String> flights() {
        Map<Integer, String> flightMap = new LinkedHashMap<>();
        List<Flight> flightList = flightService.getFlights();

        for (Flight flight : flightList) {
            flightMap.put(flight.getNo(), flight.toString());
        }

        return flightMap;
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
