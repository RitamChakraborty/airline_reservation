package com.cognizant.airline_ticket_reservation_system.service;

import com.cognizant.airline_ticket_reservation_system.dao.FlightBookingDao;
import com.cognizant.airline_ticket_reservation_system.dao.FlightBookingDaoImpl;
import com.cognizant.airline_ticket_reservation_system.model.FlightBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FlightBookingService {
    private FlightBookingDao flightBookingDao;
    private FlightBookingDaoImpl flightBookingDaoImpl;

    @Autowired
    public void setFlightBookingDao(FlightBookingDao flightBookingDao) {
        this.flightBookingDao = flightBookingDao;
    }

    @Autowired
    public void setFlightBookingDaoImpl(FlightBookingDaoImpl flightBookingDaoImpl) {
        this.flightBookingDaoImpl = flightBookingDaoImpl;
    }

    public void saveFlightBooking(FlightBooking flightBooking) {
        flightBookingDao.save(flightBooking);
    }

    public void updateFlightBooking(FlightBooking flightBooking) {
        flightBookingDaoImpl.update(flightBooking);
    }

    public FlightBooking findFlightBookingByFlightScheduledIdAndDate(Integer flightScheduleId, LocalDate date) {
        return flightBookingDaoImpl.findByFlightScheduledIdAndDate(flightScheduleId, date);
    }
}
