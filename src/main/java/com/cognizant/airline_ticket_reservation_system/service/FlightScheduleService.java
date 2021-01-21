package com.cognizant.airline_ticket_reservation_system.service;

import com.cognizant.airline_ticket_reservation_system.dao.FlightScheduleDao;
import com.cognizant.airline_ticket_reservation_system.model.FlightSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightScheduleService {
    private FlightScheduleDao flightScheduleDao;

    @Autowired
    public void setFlightScheduleDao(FlightScheduleDao flightScheduleDao) {
        this.flightScheduleDao = flightScheduleDao;
    }

    public void saveFlightSchedule(FlightSchedule flightSchedule) {
        flightScheduleDao.save(flightSchedule);
    }

    public List<FlightSchedule> getFlightSchedules() {
        return (List<FlightSchedule>) flightScheduleDao.findAll();
    }
}
