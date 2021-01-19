package com.cognizant.airline_ticket_reservation_system.dao;

import com.cognizant.airline_ticket_reservation_system.model.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDao extends CrudRepository<Flight, Integer> {
}
