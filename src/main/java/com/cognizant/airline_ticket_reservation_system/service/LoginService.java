package com.cognizant.airline_ticket_reservation_system.service;

import com.cognizant.airline_ticket_reservation_system.dao.AdminDao;
import com.cognizant.airline_ticket_reservation_system.dao.UserDao;
import com.cognizant.airline_ticket_reservation_system.model.Admin;
import com.cognizant.airline_ticket_reservation_system.model.User;
import com.cognizant.airline_ticket_reservation_system.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    private AdminDao adminDao;
    private UserDao userDao;

    @Autowired
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getUsers() {
        return (List<User>) userDao.findAll();
    }

    public boolean validAdmin(Admin admin) {
        return adminDao.findById(admin.getUsername())
                .map(value -> value.equals(admin))
                .orElse(false);
    }

    public User validateUser(UserLogin userLogin) {
        Optional<User> userOptional = userDao.findById(userLogin.getId());
        return userOptional.filter(user -> user.getPassword().equals(userLogin.getPassword()))
                .orElse(null);
    }
}
