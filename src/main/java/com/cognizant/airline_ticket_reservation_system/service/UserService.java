package com.cognizant.airline_ticket_reservation_system.service;

import com.cognizant.airline_ticket_reservation_system.dao.UserDao;
import com.cognizant.airline_ticket_reservation_system.dao.UserDaoManual;
import com.cognizant.airline_ticket_reservation_system.model.User;
import com.cognizant.airline_ticket_reservation_system.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public User getValidateUser(UserLogin userLogin) {
        Optional<User> userOptional = userDao.findById(userLogin.getId());
        return userOptional.filter(user -> user.getPassword().equals(userLogin.getPassword()))
                .orElse(null);
    }

    public User getUserById(Integer id) {
        return userDao.findById(id).orElse(null);
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public void updateUser(User user) {
        userDaoManual.update(user);
    }

    public List<User> getUsers() {
        return (List<User>) userDao.findAll();
    }
}
