package com.eride.CarReservationApp.Controllers;

import com.eride.CarReservationApp.Models.Car;
import com.eride.CarReservationApp.Models.Location;
import com.eride.CarReservationApp.dao.CarDAO;
import com.eride.CarReservationApp.dao.LocationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class BookingController {

    @Autowired
    private LocationDAO locationDAO;
    private CarDAO carDAO;

    @RequestMapping(value = "addBooking", method=RequestMethod.GET)
    public String admin(Model model){
        List<Location> locList=locationDAO.getAllLocations();
        model.addAttribute("LocationsKey", locList);


        List<Car>carList=carDAO.getAllCars();
        model.addAttribute("CarKey",carList);

        return "addBooking";
    };


}
