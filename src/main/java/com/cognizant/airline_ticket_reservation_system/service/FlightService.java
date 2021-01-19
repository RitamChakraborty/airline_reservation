package com.cognizant.airline_ticket_reservation_system.service;

import com.cognizant.airline_ticket_reservation_system.dao.FlightDao;
import com.cognizant.airline_ticket_reservation_system.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    private FlightDao flightDao;

    @Autowired
    public void setFlightDao(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    public void addFlight(Flight flight) {
        flightDao.save(flight);
    }

    public List<Flight> getFlights() {
        System.out.println(flightDao.findAll());
        return (List<Flight>) flightDao.findAll();
    }
}
