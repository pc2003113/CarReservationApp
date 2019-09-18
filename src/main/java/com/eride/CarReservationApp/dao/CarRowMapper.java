package com.eride.CarReservationApp.dao;

import com.eride.CarReservationApp.Models.Car;
import com.eride.CarReservationApp.Models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarRowMapper implements RowMapper<Car>{
    public Car mapRow(ResultSet resultSet, int ignoreThis) throws SQLException {
        int id;
    String year;
    String make;
    String vehicleModel;
    String vehicleType;


    /* Replace these temporary bindings by requesting
     * columns from resultSet
     * */
    id= resultSet.getInt("id");
    year = resultSet.getString("year");
     make= resultSet.getString("make");
    vehicleModel = resultSet.getString("vehicleModel");
    vehicleType = resultSet.getString("vehicleType");

        /*
        Replacement bindings go above
         */

    return new Car(id,year, make,vehicleModel,vehicleType);
}
}
