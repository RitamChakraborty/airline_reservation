package com.cognizant.airline_ticket_reservation_system.service;

import com.cognizant.airline_ticket_reservation_system.dao.UserDao;
import com.cognizant.airline_ticket_reservation_system.model.User;
import com.cognizant.airline_ticket_reservation_system.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getUsers() {
        return (List<User>) userDao.findAll();
    }

    public User getValidateUser(UserLogin userLogin) {
        Optional<User> userOptional = userDao.findById(userLogin.getId());
        return userOptional.filter(user -> user.getPassword().equals(userLogin.getPassword()))
                .orElse(null);
    }
}
