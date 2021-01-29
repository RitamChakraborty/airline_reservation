package com.cognizant.airline_ticket_reservation_system.dao;

import com.cognizant.airline_ticket_reservation_system.model.FlightBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class FlightBookingDaoImpl {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public FlightBooking findByFlightScheduledIdAndDate(Integer flightScheduleId, LocalDate date) {
        String query = "select * from flight_booking where scheduled_flight_id = ? and date = ?;";
        List<FlightBooking> flightBookings = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(FlightBooking.class), flightScheduleId, date);
        System.out.println(flightBookings);

        return flightBookings.isEmpty() ? null : flightBookings.get(0);
    }
}
