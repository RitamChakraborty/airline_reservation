package com.cognizant.airline_ticket_reservation_system.service;

import com.cognizant.airline_ticket_reservation_system.dao.BookingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private BookingDao bookingDao;

    @Autowired
    public void setBookingDao(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }
}
