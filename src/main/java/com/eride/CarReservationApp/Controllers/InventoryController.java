package com.eride.CarReservationApp.Controllers;


import com.eride.CarReservationApp.Models.RegisterModel;
import com.eride.CarReservationApp.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This controller has the following car related functionality
 * 1. Method to display the add car
 */


@Controller

public class InventoryController {

    @RequestMapping(value = "addCar", method=RequestMethod.GET)
    public String admin(Model model){

        return "addCar";
    };


    @RequestMapping(value = "carInventory", method=RequestMethod.GET)
    public String getCarInventory(Model model){

        return "carInventory"; //TODO --- neec to figure this out later
    };




}