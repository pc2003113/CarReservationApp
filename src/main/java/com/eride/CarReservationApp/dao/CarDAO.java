package com.eride.CarReservationApp.dao;

import com.eride.CarReservationApp.Models.Car;
import com.eride.CarReservationApp.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addCar(Car car){

        System.out.println("Inserting " + car);
        jdbcTemplate.update(
                "INSERT INTO carrent.car (year,make,vehicleModel,vehicleType) values (?,?,?,?,)",
                car.getYear(),car.getMake(),car.getVehicleModel(),car.getVehicleType());
    }


    public List<Car> getAllCars(){


        return jdbcTemplate.query("select * from carrent.car ",
                new CarRowMapper());

    }

//Any one of the parameters can be used to find the Car
    public Car findCar( int id, String year,String make,String vehicleModel,String vehicleType){
    List<Car> matches = jdbcTemplate.query(
    "select * from carrent.car where id=? or (year) = ? or make=? or vehicleModel =? or vehicleType=?",
   new Object[] { id,year,make,vehicleModel,vehicleType },
    new CarRowMapper());
    if (matches.isEmpty()){
    return null;
    }
    else {
    return matches.get(0);
    }
   }


   public void updateCar(Car car){
       System.out.println("Updating " + car);
       System.out.println("Year:" + car.getYear());
       System.out.println("Make:" + car.getMake());
       System.out.println("Vehicle Model:" + car.getVehicleModel());
       System.out.println("Vehicle Type:" + car.getVehicleType());

       jdbcTemplate.update(
               "UPDATE carrent.car SET year=?,make=?, vehicleModel=? where id=?",
                car.getYear(),car.getMake(),car.getVehicleModel(),car.getId());
   }

    public void deleteCar(int id){

        jdbcTemplate.update(
                "delete from carrent.car where id=?",
                id);
    }


}
