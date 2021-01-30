package com.cognizant.airline_ticket_reservation_system.service;

import com.cognizant.airline_ticket_reservation_system.dao.PassengerDao;
import com.cognizant.airline_ticket_reservation_system.dao.PassengerDaoImpl;
import com.cognizant.airline_ticket_reservation_system.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    private PassengerDao passengerDao;
    private PassengerDaoImpl passengerDaoImpl;

    @Autowired
    public void setPassengerDao(PassengerDao passengerDao) {
        this.passengerDao = passengerDao;
    }

    @Autowired
    public void setPassengerDaoImpl(PassengerDaoImpl passengerDaoImpl) {
        this.passengerDaoImpl = passengerDaoImpl;
    }

    public void saveAllPassengers(List<Passenger> passengers) {
        passengerDao.saveAll(passengers);
    }

    public List<Passenger> getPassengersByBookingId(String bookingId) {
        return passengerDaoImpl.findAllByBookingId(bookingId);
    }
}
