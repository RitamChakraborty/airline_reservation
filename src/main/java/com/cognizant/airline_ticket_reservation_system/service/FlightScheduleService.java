package com.cognizant.airline_ticket_reservation_system.service;

import com.cognizant.airline_ticket_reservation_system.dao.FlightScheduleDao;
import com.cognizant.airline_ticket_reservation_system.dao.FlightScheduleDaoImpl;
import com.cognizant.airline_ticket_reservation_system.model.BookTicket;
import com.cognizant.airline_ticket_reservation_system.model.FlightSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightScheduleService {
    private FlightScheduleDao flightScheduleDao;
    private FlightScheduleDaoImpl flightScheduleDaoImpl;

    @Autowired
    public void setFlightScheduleDao(FlightScheduleDao flightScheduleDao) {
        this.flightScheduleDao = flightScheduleDao;
    }

    @Autowired
    public void setFlightScheduleDaoImpl(FlightScheduleDaoImpl flightScheduleDaoImpl) {
        this.flightScheduleDaoImpl = flightScheduleDaoImpl;
    }

    public void saveFlightSchedule(FlightSchedule flightSchedule) {
        flightScheduleDao.save(flightSchedule);
    }

    public List<FlightSchedule> getFlightSchedules() {
        return (List<FlightSchedule>) flightScheduleDao.findAll();
    }

    public List<FlightSchedule> getFlightSchedulesByDateSourceDestination(BookTicket bookTicket) {
        return flightScheduleDaoImpl.getFlightSchedulesByDateSourceDestination(bookTicket);
    }

    public FlightSchedule getFlightScheduleById(Integer flightScheduleId) {
        return flightScheduleDao.findById(flightScheduleId).orElse(null);
    }
}
