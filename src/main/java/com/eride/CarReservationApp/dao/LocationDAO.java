package com.eride.CarReservationApp.dao;

import com.eride.CarReservationApp.Models.Car;
import com.eride.CarReservationApp.Models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addLocation(Location location) {

        System.out.println("Inserting " + location);
        jdbcTemplate.update(
                "INSERT INTO carrent.location (id,address,city,state,zipcode,country) values (?,?,?,?,?,?)",
                location.getId(), location.getAddress(), location.getCity(), location.getState(), location.getZipcode(), location.getCountry());
    }
    public List<Location> getAllLocations(){


        return jdbcTemplate.query("select * from carrent.location ",
                new LocationRowMapper());

    }

    //Any one of the parameters can be used to find the Car
    public Location findLocation( String id, String address,String city,String state,String zipcode,String country){
        List<Location> matches = jdbcTemplate.query(
                "select * from carrent.location where id=? or address = ? or city=? or state=? or zipcode=? or country=?",
                new Object[] { id,address,city,state,zipcode,country },
                new LocationRowMapper());
        if (matches.isEmpty()){
            return null;
        }
        else {
            return matches.get(0);
        }
    }



    public void updateLocation(Location location){
        System.out.println("id " + location.getId());
        System.out.println("address:" + location.getAddress());
        System.out.println("city:" + location.getCity());
        System.out.println("State:" + location.getState());
        System.out.println("zipcode:" + location.getZipcode());
        System.out.println("country:" + location.getCountry());


        jdbcTemplate.update(
                "UPDATE carrent.location SET id=?, city=? where id=?",
                location.getId(),location.getCity(),location.getId());
    }

    public void deleteLocation(String id){

        jdbcTemplate.update(
                "delete from carrent.location where id=?",
                id);
    }






}