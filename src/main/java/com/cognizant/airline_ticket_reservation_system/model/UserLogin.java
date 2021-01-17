package com.cognizant.airline_ticket_reservation_system.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Component
public class UserLogin {
    @NotNull(message = "{error.id}")
    private Integer id;
    @NotBlank(message = "{error.password}")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "id=" + id +
                ", password='" + password + '\'' +
                '}';
    }
}
