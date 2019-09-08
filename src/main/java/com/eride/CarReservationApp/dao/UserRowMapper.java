package com.eride.CarReservationApp.dao;

import com.eride.CarReservationApp.Models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User>{
        public User mapRow(ResultSet resultSet, int ignoreThis) throws SQLException {
    String userid;
    String password;
    String fname;
    String lname;
    boolean admin;
    String email;


    /* Replace these temporary bindings by requesting
     * columns from resultSet
     * */
    userid = resultSet.getString("userid");
     password= resultSet.getString("password");
    fname = resultSet.getString("fname");
    lname = resultSet.getString("lname");
    admin=(boolean) resultSet.getBoolean("admin");
    email = resultSet.getString("email");
        /*
        Replacement bindings go above
         */

    return new User(userid, password,fname,lname,email,admin);
}
}
