package com.cognizant.airline_ticket_reservation_system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NotNull(message = "{flight.seatsEconomy}")
    @PositiveOrZero(message = "{flight.seatsEconomy.negative}")
    private Integer seatsEconomy;
    @NotNull(message = "{flight.seatsBusiness}")
    @PositiveOrZero(message = "{flight.seatsBusiness.negative}")
    private Integer seatsBusiness;

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

    public Integer getSeatsEconomy() {
        return seatsEconomy;
    }

    public void setSeatsEconomy(Integer seatsEconomy) {
        this.seatsEconomy = seatsEconomy;
    }

    public Integer getSeatsBusiness() {
        return seatsBusiness;
    }

    public void setSeatsBusiness(Integer seatsBusiness) {
        this.seatsBusiness = seatsBusiness;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "no=" + no +
                ", airline='" + airline + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", seatsEconomy=" + seatsEconomy +
                ", seatsBusiness=" + seatsBusiness +
                '}';
    }
}
