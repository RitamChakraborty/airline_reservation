package com.cognizant.airline_ticket_reservation_system.model;

public class PassengerSeats {
    private Integer economySeats = 0;
    private Integer businessSeats = 0;

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

    public int getTotalPassengerCount() {
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
