package com.eride.CarReservationApp.dao;

import com.eride.CarReservationApp.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addUser(User user){
        System.out.println("Inserting " + user);
        jdbcTemplate.update(
                "INSERT INTO carrent.user values (?,?,?,?,?)",
                user.getUserid(),user.getPassword(),user.getFname(),user.getLname(),user.isAdmin(),user.getEmail());
    }

}
