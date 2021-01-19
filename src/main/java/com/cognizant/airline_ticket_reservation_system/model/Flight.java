package com.cognizant.airline_ticket_reservation_system.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {
    @Id
    private Integer no;
    private String airline;
    private String model;
    private String type;
    private Integer seatsEconomy;
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
