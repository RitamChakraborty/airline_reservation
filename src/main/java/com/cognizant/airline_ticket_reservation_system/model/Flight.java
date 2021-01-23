package com.cognizant.airline_ticket_reservation_system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;
    private String airline;
    private String model;
    private String type;
    @NotNull(message = "{error.flight.economySeats}")
    @Digits(integer = 3, fraction = 0, message = "{error.flight.economySeats.float}")
    @PositiveOrZero(message = "{error.flight.economySeats.negative}")
    private Integer economySeats;
    @NotNull(message = "{error.flight.businessSeats}")
    @Digits(integer = 3, fraction = 0, message = "{error.flight.businessSeats.float}")
    @PositiveOrZero(message = "{error.flight.businessSeats.negative}")
    private Integer businessSeats;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    @Override
    public String toString() {
        return "Flight{" +
                "no=" + no +
                ", airline='" + airline + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", economySeats=" + economySeats +
                ", businessSeats=" + businessSeats +
                '}';
    }
}
