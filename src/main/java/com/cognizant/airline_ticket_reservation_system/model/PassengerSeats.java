package com.cognizant.airline_ticket_reservation_system.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class PassengerSeats {
    @NotNull(message = "{error.passengerSeats.economySeats}")
    @PositiveOrZero(message = "{error.passengerSeats.economySeats.negative}")
    private Integer economySeats;
    @NotNull(message = "{error.passengerSeats.businessSeats}")
    @PositiveOrZero(message = "{error.passengerSeats.businessSeats.negative}")
    private Integer businessSeats;

    public Integer getEconomySeats() {
        return economySeats;
    }

    public void setEconomySeats(Integer economySeats) {
        this.economySeats = economySeats;
    }

    public Integer getBusinessSeats() {
        return businessSeats;
    }

    public void setBusinessSeats(Integer businessSeats) {
        this.businessSeats = businessSeats;
    }

    public Integer getTotalPassengerCount() {
        return economySeats + businessSeats;
    }

    @Override
    public String toString() {
        return "PassengerSeats{" +
                "economySeats=" + economySeats +
                ", businessSeats=" + businessSeats +
                '}';
    }
}
