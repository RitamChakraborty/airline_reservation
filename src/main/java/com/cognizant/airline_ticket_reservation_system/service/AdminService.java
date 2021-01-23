package com.cognizant.airline_ticket_reservation_system.service;

import com.cognizant.airline_ticket_reservation_system.dao.AdminDao;
import com.cognizant.airline_ticket_reservation_system.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private AdminDao adminDao;

    @Autowired
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public Admin getAdminByUsername(String username) {
        return adminDao.findById(username).orElse(null);
    }

    public boolean validAdmin(Admin admin) {
        return adminDao.findById(admin.getUsername())
                .map(value -> value.equals(admin))
                .orElse(false);
    }
}
