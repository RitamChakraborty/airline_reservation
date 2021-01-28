package com.cognizant.airline_ticket_reservation_system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    private Integer scheduledFlightId;
    private Integer economySeatsAvailable;
    private Integer businessSeatsAvailable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "FlightBooking{" +
                "id=" + id +
                ", date=" + date +
                ", scheduledFlightId=" + scheduledFlightId +
                ", economySeatsAvailable=" + economySeatsAvailable +
                ", businessSeatsAvailable=" + businessSeatsAvailable +
                '}';
    }
}
