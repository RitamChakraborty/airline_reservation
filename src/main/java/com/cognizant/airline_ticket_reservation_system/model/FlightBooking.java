package com.cognizant.airline_ticket_reservation_system.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.LocalDate;

@Entity
public class FlightBooking {
    @Id
    private String id;
    private LocalDate date;
    private Integer scheduledFlightId;
    private Integer economySeatsAvailable;
    private Integer businessSeatsAvailable;
    @Transient
    private FlightSchedule flightSchedule;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getScheduledFlightId() {
        return scheduledFlightId;
    }

    public void setScheduledFlightId(Integer scheduledFlightId) {
        this.scheduledFlightId = scheduledFlightId;
    }

    public Integer getEconomySeatsAvailable() {
        return economySeatsAvailable;
    }

    public void setEconomySeatsAvailable(Integer economySeatsAvailable) {
        this.economySeatsAvailable = economySeatsAvailable;
    }

    public Integer getBusinessSeatsAvailable() {
        return businessSeatsAvailable;
    }

    public void setBusinessSeatsAvailable(Integer businessSeatsAvailable) {
        this.businessSeatsAvailable = businessSeatsAvailable;
    }

    public FlightSchedule getFlightSchedule() {
        return flightSchedule;
    }

    public void setFlightSchedule(FlightSchedule flightSchedule) {
        this.flightSchedule = flightSchedule;
    }

    @Override
    public String toString() {
        return "FlightBooking{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", scheduledFlightId=" + scheduledFlightId +
                ", economySeatsAvailable=" + economySeatsAvailable +
                ", businessSeatsAvailable=" + businessSeatsAvailable +
                ", flightSchedule=" + flightSchedule +
                '}';
    }
}
