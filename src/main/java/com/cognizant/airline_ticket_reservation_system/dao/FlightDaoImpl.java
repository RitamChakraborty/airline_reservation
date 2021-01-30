package com.cognizant.airline_ticket_reservation_system.dao;

import com.cognizant.airline_ticket_reservation_system.constant.Queries;
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
        String query = Queries.FLIGHT_UPDATE;

        jdbcTemplate.update(
                query,
                flight.getAirline(),
                flight.getModel(),
                flight.getType(),
                flight.getEconomySeats(),
                flight.getBusinessSeats(),
                flight.getNo()
        );
    }
}
