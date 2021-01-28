package com.cognizant.airline_ticket_reservation_system.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Booking {
    @Id
    private String id;
    private String flightBookingId;
    private Integer userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlightBookingId() {
        return flightBookingId;
    }

    public void setFlightBookingId(String flightBookingId) {
        this.flightBookingId = flightBookingId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", flightBookingId=" + flightBookingId +
                ", userId=" + userId +
                '}';
    }
}
