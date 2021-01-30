package com.cognizant.airline_ticket_reservation_system.dao;

import com.cognizant.airline_ticket_reservation_system.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingDaoImpl {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Booking> findByFlightBookingId(String flightBookingId) {
        String query = "select * from booking where flight_booking_id = ?;";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Booking.class), flightBookingId);
    }

    public List<Booking> findByUserId(Integer userId) {
        String query = "select * from booking where user_id = ?;";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Booking.class), userId);
    }

    public Booking findByFlightBookingIdAndUserId(String flightBookingId, Integer userId) {
        String query = "select * from booking where flight_booking_id = ? and user_id = ?;";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Booking.class), flightBookingId, userId).get(0);
    }
}
