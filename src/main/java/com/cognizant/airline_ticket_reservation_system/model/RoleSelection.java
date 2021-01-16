package com.cognizant.airline_ticket_reservation_system.model;

import org.springframework.stereotype.Component;

@Component
public class RoleSelection {
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RoleSelection{" +
                "role='" + role + '\'' +
                '}';
    }
}
