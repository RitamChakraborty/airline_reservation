package com.cognizant.airline_ticket_reservation_system.service;

import com.cognizant.airline_ticket_reservation_system.dao.UserDao;
import com.cognizant.airline_ticket_reservation_system.dao.UserDaoManual;
import com.cognizant.airline_ticket_reservation_system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserDao userDao;
    private UserDaoManual userDaoManual;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setUserDaoManual(UserDaoManual userDaoManual) {
        this.userDaoManual = userDaoManual;
    }

    public User getUserById(Integer id) {
        return userDao.findById(id).orElse(null);
    }

    public void updateUser(User user) {
        userDaoManual.update(user);
    }

    public List<User> getUsers() {
        return (List<User>) userDao.findAll();
    }
}
