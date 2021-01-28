package com.cognizant.airline_ticket_reservation_system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer flightBookingId;
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlightBookingId() {
        return flightBookingId;
    }

    public void setFlightBookingId(Integer flightBookingId) {
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
