package com.cognizant.airline_ticket_reservation_system.dao;

import com.cognizant.airline_ticket_reservation_system.constant.Queries;
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
        String query = Queries.FLIGHT_BOOKING_FIND_BY_FLIGHT_SCHEDULED_ID_AND_DATE;
        List<FlightBooking> flightBookings = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(FlightBooking.class), flightScheduleId, date);

        return flightBookings.isEmpty() ? null : flightBookings.get(0);
    }

    public void update(FlightBooking flightBooking) {
        String query = Queries.FLIGHT_BOOKING_UPDATE;
        jdbcTemplate.update(query, flightBooking.getEconomySeatsAvailable(), flightBooking.getBusinessSeatsAvailable());
    }
}
