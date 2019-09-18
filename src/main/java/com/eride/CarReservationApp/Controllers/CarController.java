package com.eride.CarReservationApp.Controllers;


import com.eride.CarReservationApp.Models.Car;
import com.eride.CarReservationApp.dao.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Year;

/**
 * This controller has the following car related functionality
 * 1. Method to display the add car
 */


@Controller
@RequestMapping("car")

public class CarController {

    @Autowired
    private CarDAO carDAO;

    // create funtionality -display the tempalate required for input using GET method

    @RequestMapping(value = "addCar", method=RequestMethod.GET)
    public String admin(Model model){

        return "addCar";
    };

    //create functionality of the car ( C in CRUD)
    @RequestMapping(value = "addCar", method = RequestMethod.POST)
    public String saveNewCar(Model model,
                                        @RequestParam String year,
                                        @RequestParam String make,
                                        @RequestParam String vehicleModel,
                                        @RequestParam String vehicleType
    ){
       /*
       This is the view model/spring model if you want it to be sent to the view( html) In this case we are redirectling back to the car Inventory
     model.addAttribute("year",year);
        model.addAttribute("make",make);
        model.addAttribute("vehicleModel",vehicleModel);
        model.addAttribute("vehicleType",vehicleType);
        */

        Car cr= new Car(0,year,make,vehicleModel,vehicleType);

        carDAO.addCar(cr);

        System.out.println("Saved it..."  + year + " " + make+ " " + vehicleModel+ " " + vehicleType);
        return "redirect:/car/carInventory";
    }



    // this is to code for read functionality  for all cars
    @RequestMapping(value = "carInventory", method = RequestMethod.GET)
    public String carsList(Model model){
        model.addAttribute("carskey", carDAO.getAllCars());

        return "carInventory";

    }
    // this is to code for read functionality  for 1 user ( The R in CRUD)
    @RequestMapping(value = "/modify", method=RequestMethod.GET)
    public String getToModifyCar(Model model,@RequestParam int id){

        Car c = carDAO.findCar(id,null,null,null,null);
        model.addAttribute("c",c);
        return "modifyCar";

    };
     // this is to code for UPDATE functionality  for 1 car ( The U in CRUD)
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyCar(Model model,
                            @RequestParam int id,
                             @RequestParam String year,
                             @RequestParam String make,
                             @RequestParam String vehicleModel
                             //@RequestParam String vehicleType
    ){

        System.out.println("c"+year);
        Car c = new Car(id,year, make,vehicleModel,null);


        carDAO.updateCar(c);

        return "redirect:/admin";
    }

    // this is to code for DELETE functionality  for 1 user ( The U in CRUD)
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCar(Model model,
                             @RequestParam int id
    ){

        System.out.println("c"+id);


       carDAO.deleteCar(id);

        return "redirect:/admin";
    }







}