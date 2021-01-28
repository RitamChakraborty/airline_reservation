package com.cognizant.airline_ticket_reservation_system.dao;

import com.cognizant.airline_ticket_reservation_system.model.FlightBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class FlightBookingDaoImpl {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public FlightBooking findByFlightScheduledIdAndDate(Integer flightScheduleId, LocalDate date) {
        String query = "select * from flight_booking where scheduled_flight_id = ? and date = ?;";
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(), flightScheduleId, date);
    }
}
