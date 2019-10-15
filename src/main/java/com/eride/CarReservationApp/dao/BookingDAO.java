package com.eride.CarReservationApp.dao;

import com.eride.CarReservationApp.Models.Booking;
import com.eride.CarReservationApp.Models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addBookings(Booking bookings) {

        System.out.println("Inserting " + bookings);
        jdbcTemplate.update(
                "INSERT INTO carrent.booking (branchID,startDate,endDate,vehicleType) values (?,?,?,?)",
                bookings.getBranchID(),bookings.getStartDate(),bookings.getEndDate(),bookings.getVehicleType());
    }
    public List<Booking> getAllBookings(){


        return jdbcTemplate.query("select * from carrent.booking",
                new BookingRowMapper());

    }

    //Any one of the parameters can be used to find the booking
    public Booking findBooking( String bookID, String startDate,String endDate,String vehicleType){
        List<Booking> matches = jdbcTemplate.query(
                "select * from carrent.booking where bookID=? or startDate = ? or endDate=? or vehicleType=? ",
                new Object[] { bookID,startDate,endDate,vehicleType },
                new BookingRowMapper());
        if (matches.isEmpty()){
            return null;
        }
        else {
            return matches.get(0);
        }
    }



    public void updateBooking(Booking booking){
        System.out.println("branchID " + booking.getBranchID());
        System.out.println("startDate:" + booking.getStartDate());
        System.out.println("endDate:" + booking.getEndDate());
        System.out.println("vehicleType:" + booking.getVehicleType());



        jdbcTemplate.update(
                "UPDATE carrent.booking SET branchID=?,startDate=?,endDate=?,vehicleType=? where id=?",
                booking.getBranchID(),booking.getStartDate(),booking.getEndDate(),booking.getVehicleType());
    }

    public void deleteBoooking(String bookID){

        jdbcTemplate.update(
                "delete from carrent.booking where bookID=?",
                bookID);
    }






}