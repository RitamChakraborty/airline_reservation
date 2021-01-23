package com.cognizant.airline_ticket_reservation_system.dao;

import com.cognizant.airline_ticket_reservation_system.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FlightDaoImpl {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void update(Flight flight) {
        jdbcTemplate.update(
                "update flight set airline = ?, model = ?, type = ?, economy_seats = ?, business_seats = ? where no = ?",
                flight.getAirline(),
                flight.getModel(),
                flight.getType(),
                flight.getEconomySeats(),
                flight.getBusinessSeats(),
                flight.getNo()
        );
    }
}
