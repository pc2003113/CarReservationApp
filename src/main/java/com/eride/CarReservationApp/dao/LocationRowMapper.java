package com.eride.CarReservationApp.dao;

import com.eride.CarReservationApp.Models.Car;
import com.eride.CarReservationApp.Models.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationRowMapper implements RowMapper<Location>{
    public Location mapRow(ResultSet resultSet, int ignoreThis) throws SQLException {
    String id;
    String address;
    String city;
    String state;
    String zipcode;
    String country;


    /* Replace these temporary bindings by requesting
     * columns from resultSet
     * */
    id= resultSet.getString("id");
    address = resultSet.getString("address");
    city= resultSet.getString("city");
    state = resultSet.getString("state");
    zipcode = resultSet.getString("zipcode");
    country = resultSet.getString("country");

        /*
        Replacement bindings go above
         */

    return new Location(id,address, city,state,zipcode,country);
}
}
