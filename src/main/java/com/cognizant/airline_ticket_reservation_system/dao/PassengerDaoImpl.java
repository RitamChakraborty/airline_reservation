package com.cognizant.airline_ticket_reservation_system.dao;

import com.cognizant.airline_ticket_reservation_system.constant.Queries;
import com.cognizant.airline_ticket_reservation_system.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PassengerDaoImpl {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Passenger> findAllByBookingId(String bookingId) {
        String query = Queries.PASSENGER_FIND_ALL_BY_BOOKING_ID;
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Passenger.class), bookingId);
    }
}
