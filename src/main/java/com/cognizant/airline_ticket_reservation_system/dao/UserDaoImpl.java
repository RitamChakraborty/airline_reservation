package com.cognizant.airline_ticket_reservation_system.dao;

import com.cognizant.airline_ticket_reservation_system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer lastUserId() {
        String query = "select max(id) from user;";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    public void update(User user) {
        jdbcTemplate.update(
                "update user set password = ?, name = ?, age = ?, gender = ?, email = ?, address = ?, phone = ?, secret_question = ?, answer = ? where id = ?;",
                user.getPassword(),
                user.getName(),
                user.getAge(),
                user.getGender(),
                user.getEmail(),
                user.getAddress(),
                user.getPhone(),
                user.getSecretQuestion(),
                user.getAnswer(),
                user.getId()
        );
    }
}
