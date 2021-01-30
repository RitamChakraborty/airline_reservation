package com.cognizant.airline_ticket_reservation_system.dao;

import com.cognizant.airline_ticket_reservation_system.constant.Queries;
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
        String query = Queries.BOOKING_FIND_BY_FLIGHT_BOOKING_ID;
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Booking.class), flightBookingId);
    }

    public List<Booking> findByUserId(Integer userId) {
        String query = Queries.BOOKING_FIND_BY_USER_ID;
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Booking.class), userId);
    }

    public Booking findByFlightBookingIdAndUserId(String flightBookingId, Integer userId) {
        String query = Queries.BOOKING_FIND_BY_FLIGHT_BOOKING_ID_AND_USER_ID;
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Booking.class), flightBookingId, userId).get(0);
    }
}
