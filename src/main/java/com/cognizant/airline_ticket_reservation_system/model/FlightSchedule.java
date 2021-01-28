package com.cognizant.airline_ticket_reservation_system.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalTime;

@Entity
public class FlightSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer flightNo;
    @Transient
    private Flight flight;
    private String source;
    private String destination;
    @NotNull(message = "{error.flightSchedule.economySeatCost}")
    @PositiveOrZero(message = "{error.flightSchedule.economySeatCost.negative}")
    private Integer economySeatCost;
    @NotNull(message = "{error.flightSchedule.businessSeatCost}")
    @PositiveOrZero(message = "{error.flightSchedule.businessSeatCost.negative}")
    private Integer businessSeatCost;
    @NotNull(message = "{error.flightSchedule.arrivalTime}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime arrivalTime;
    @NotNull(message = "{error.flightSchedule.departureTime}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime departureTime;
    private boolean sun;
    private boolean mon;
    private boolean tue;
    private boolean wed;
    private boolean thu;
    private boolean fri;
    private boolean sat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(Integer flightNo) {
        this.flightNo = flightNo;
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

    public Integer getEconomySeatCost() {
        return economySeatCost;
    }

    public void setEconomySeatCost(Integer cost) {
        this.economySeatCost = cost;
    }

    public Integer getBusinessSeatCost() {
        return businessSeatCost;
    }

    public void setBusinessSeatCost(Integer businessSeatCost) {
        this.businessSeatCost = businessSeatCost;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public boolean isSun() {
        return sun;
    }

    public void setSun(boolean sun) {
        this.sun = sun;
    }

    public boolean isMon() {
        return mon;
    }

    public void setMon(boolean mon) {
        this.mon = mon;
    }

    public boolean isTue() {
        return tue;
    }

    public void setTue(boolean tue) {
        this.tue = tue;
    }

    public boolean isWed() {
        return wed;
    }

    public void setWed(boolean wed) {
        this.wed = wed;
    }

    public boolean isThu() {
        return thu;
    }

    public void setThu(boolean thu) {
        this.thu = thu;
    }

    public boolean isFri() {
        return fri;
    }

    public void setFri(boolean fri) {
        this.fri = fri;
    }

    public boolean isSat() {
        return sat;
    }

    public void setSat(boolean sat) {
        this.sat = sat;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "FlightSchedule{" +
                "id=" + id +
                ", flightNo=" + flightNo +
                ", flight=" + flight +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", economySeatCost=" + economySeatCost +
                ", businessSeatCost=" + businessSeatCost +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", sun=" + sun +
                ", mon=" + mon +
                ", tue=" + tue +
                ", wed=" + wed +
                ", thu=" + thu +
                ", fri=" + fri +
                ", sat=" + sat +
                '}';
    }
}
