package com.cognizant.airline_ticket_reservation_system.dao;

import com.cognizant.airline_ticket_reservation_system.model.BookTicket;
import com.cognizant.airline_ticket_reservation_system.model.FlightSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlightScheduleDaoImpl {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<FlightSchedule> getFlightSchedulesByDateSourceDestination(BookTicket bookTicket) {
        String dayOfWeek = bookTicket.getDate().getDayOfWeek().toString();
        String source = bookTicket.getSource();
        String destination = bookTicket.getDestination();
        String date = dayOfWeek.toLowerCase().substring(0, 3);
        String query = String.format("select * from flight_schedule where source = ? and destination = ? and %s = 1;", date);

        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(FlightSchedule.class), source, destination);
    }
}
