package com.cognizant.airline_ticket_reservation_system.controller;

import com.cognizant.airline_ticket_reservation_system.model.Flight;
import com.cognizant.airline_ticket_reservation_system.model.FlightSchedule;
import com.cognizant.airline_ticket_reservation_system.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FlightScheduleController {
    private FlightService flightService;

    @Autowired
    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/add-schedule")
    public String addSchedule(@ModelAttribute("flightSchedule") FlightSchedule flightSchedule) {
        return "add-schedule";
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
