package com.eride.CarReservationApp.dao;

import com.eride.CarReservationApp.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addUser(User user){

        System.out.println("Inserting " + user);
        jdbcTemplate.update(
                "INSERT INTO carrent.user (userid,password,fname,lname,email,admin) values (?,?,?,?,?,?)",
                user.getUserid(),user.getPassword(),user.getFname(),user.getLname(),user.getEmail(),user.isAdmin());
    }


    public List<User> getAllUsers(){


        return jdbcTemplate.query("select * from carrent.user ",
                new UserRowMapper());

    }

//Any one of the parameters can be used to find the user
    public User findUser(String userid,String fname,String lname,String email){
    List<User> matches = jdbcTemplate.query(
    "select * from carrent.user where lower(userid) = ? or fname=? or lname =? or email=?",
   new Object[] { userid.toLowerCase(),fname,lname,email },
    new UserRowMapper());
    if (matches.isEmpty()){
    return null;
    }
    else {
    return matches.get(0);
    }
   }


   public void updateUser(User user){
       System.out.println("Updating " + user);
       System.out.println("UserID:" + user.getUserid()+":");
       System.out.println("Password:" + user.getPassword()+":");
       System.out.println("Fname:" + user.getFname()+":");
       System.out.println("Lname:" + user.getLname()+":");
       System.out.println("Email:" + user.getEmail()+":");
       jdbcTemplate.update(
               "UPDATE carrent.user SET userid=?,fname=?, lname=?, password=?, email=? where userid=?",
                user.getUserid(),user.getFname(), user.getLname(), user.getPassword(), user.getEmail(),user.getUserid());
   }

    public void deleteUser(String userid){

        jdbcTemplate.update(
                "delete from carrent.user where userid=?",
                userid);
    }


}
