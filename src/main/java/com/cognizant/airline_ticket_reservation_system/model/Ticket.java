package com.cognizant.airline_ticket_reservation_system.model;

import java.time.LocalDate;
import java.util.List;

public class Ticket {
    private User user;
    private FlightSchedule flightSchedule;
    private Flight flight;
    private LocalDate date;
    private Integer economySeatsAvailable;
    private Integer businessSeatsAvailable;
    private PassengerSeats passengerSeats;
    private Integer cost;
    private List<Passenger> passengers;
    private Boolean flightIsScheduled;
    private String flightBookingId;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FlightSchedule getFlightSchedule() {
        return flightSchedule;
    }

    public void setFlightSchedule(FlightSchedule flightSchedule) {
        this.flightSchedule = flightSchedule;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public PassengerSeats getPassengerSeats() {
        return passengerSeats;
    }

    public void setPassengerSeats(PassengerSeats passengerSeats) {
        this.passengerSeats = passengerSeats;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Boolean getFlightIsScheduled() {
        return flightIsScheduled;
    }

    public void setFlightIsScheduled(Boolean flightIsScheduled) {
        this.flightIsScheduled = flightIsScheduled;
    }

    public String getFlightBookingId() {
        return flightBookingId;
    }

    public void setFlightBookingId(String flightBookingId) {
        this.flightBookingId = flightBookingId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "user=" + user +
                ", flightSchedule=" + flightSchedule +
                ", flight=" + flight +
                ", date=" + date +
                ", economySeatsAvailable=" + economySeatsAvailable +
                ", businessSeatsAvailable=" + businessSeatsAvailable +
                ", passengerSeats=" + passengerSeats +
                ", cost=" + cost +
                ", passengers=" + passengers +
                ", flightIsScheduled=" + flightIsScheduled +
                ", flightBookingId='" + flightBookingId + '\'' +
                '}';
    }
}
