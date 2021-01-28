package com.cognizant.airline_ticket_reservation_system.service;

import com.cognizant.airline_ticket_reservation_system.dao.PassengerDao;
import com.cognizant.airline_ticket_reservation_system.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    private PassengerDao passengerDao;

    @Autowired
    public void setPassengerDao(PassengerDao passengerDao) {
        this.passengerDao = passengerDao;
    }

    public void saveAllPassengers(List<Passenger> passengers) {
        passengerDao.saveAll(passengers);
    }
}
