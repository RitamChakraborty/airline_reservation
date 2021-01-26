package com.cognizant.airline_ticket_reservation_system.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class BookTicket {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "{error.bookTicket.date}")
    private LocalDate date;
    private String source;
    private String destination;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "FlightSearch{" +
                "date=" + date +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
