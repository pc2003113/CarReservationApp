package com.eride.CarReservationApp.dao;

import com.eride.CarReservationApp.Models.Booking;
import com.eride.CarReservationApp.Models.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingRowMapper implements RowMapper<Booking>{
    public Booking mapRow(ResultSet resultSet, int ignoreThis) throws SQLException {
    int ID;
    String branchID;
    String startDate;
    String endDate;
    String vehicleType;

    ID= resultSet.getInt("ID");
    branchID= resultSet.getString("branchID");
    startDate = resultSet.getString("startDate");
    endDate= resultSet.getString("endDate");
    vehicleType = resultSet.getString("vehicleType");


    return new Booking(ID,branchID,startDate, endDate,vehicleType);
}
}
