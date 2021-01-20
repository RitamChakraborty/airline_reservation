package com.cognizant.airline_ticket_reservation_system.service;

import com.cognizant.airline_ticket_reservation_system.dao.FlightDao;
import com.cognizant.airline_ticket_reservation_system.dao.FlightDaoCustom;
import com.cognizant.airline_ticket_reservation_system.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    private FlightDao flightDao;
    private FlightDaoCustom flightDaoCustom;

    @Autowired
    public void setFlightDao(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Autowired
    public void setFlightDaoCustom(FlightDaoCustom flightDaoCustom) {
        this.flightDaoCustom = flightDaoCustom;
    }

    public void addFlight(Flight flight) {
        flightDao.save(flight);
    }

    public Flight getFlightByNo(Integer no) {
        return flightDao.findById(no)
                .orElse(null);
    }

    public void updateFlight(Flight flight) {
        flightDaoCustom.update(flight);
    }

    public void deleteFlightByNo(Integer no) {
        flightDao.deleteById(no);
    }

    public List<Flight> getFlights() {
        return (List<Flight>) flightDao.findAll();
    }
}
