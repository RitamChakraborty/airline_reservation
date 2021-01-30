package com.cognizant.airline_ticket_reservation_system.service;

import com.cognizant.airline_ticket_reservation_system.dao.BookingDao;
import com.cognizant.airline_ticket_reservation_system.dao.BookingDaoImpl;
import com.cognizant.airline_ticket_reservation_system.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private BookingDao bookingDao;
    private BookingDaoImpl bookingDaoImpl;

    @Autowired
    public void setBookingDao(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    @Autowired
    public void setBookingDaoImpl(BookingDaoImpl bookingDaoImpl) {
        this.bookingDaoImpl = bookingDaoImpl;
    }

    public void saveBooking(Booking booking) {
        bookingDao.save(booking);
    }

    public List<Booking> getBookingsByFlightBookingId(String flightBookingId) {
        return bookingDaoImpl.findByFlightBookingId(flightBookingId);
    }

    public Booking getBookingByBookingId(String bookingId) {
        return bookingDao.findById(bookingId).orElse(null);
    }

    public List<Booking> getBookingsByUserId(Integer userId) {
        return bookingDaoImpl.findByUserId(userId);
    }

    public Booking getBookingByFlightBookingIdAndUserId(String flightBookingId, Integer id) {
        return bookingDaoImpl.findByFlightBookingIdAndUserId(flightBookingId, id);
    }
}
