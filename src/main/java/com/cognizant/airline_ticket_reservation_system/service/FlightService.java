package com.cognizant.airline_ticket_reservation_system.service;

import com.cognizant.airline_ticket_reservation_system.dao.FlightDao;
import com.cognizant.airline_ticket_reservation_system.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
