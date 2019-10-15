package com.eride.CarReservationApp.Controllers;

import com.eride.CarReservationApp.Models.Car;
import com.eride.CarReservationApp.Models.Location;
import com.eride.CarReservationApp.dao.LocationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("location")



public class LocationController {

    @Autowired
    private LocationDAO locationDAO;



    @RequestMapping(value = "addLocation", method=RequestMethod.GET)
    public String admin(Model model){

        return "addLocation";
    };

    //create functionality of the location ( C in CRUD)
    @RequestMapping(value = "addLocation", method = RequestMethod.POST)
    public String saveNewLocation(Model model,
                             @RequestParam String id,
                             @RequestParam String address,
                             @RequestParam String city,
                             @RequestParam String state,
                             @RequestParam String zipcode,
                             @RequestParam String country
    ){
       /*
       This is the view model/spring model if you want it to be sent to the view( html) In this case we are redirectling back to the location Inventory
     model.addAttribute("year",year);
        model.addAttribute("make",make);
        model.addAttribute("vehicleModel",vehicleModel);
        model.addAttribute("vehicleType",vehicleType);
        */

        Location location= new Location(id,address,city,state,zipcode,country
        );

       locationDAO.addLocation(location);

        System.out.println("Saved it..."  + id + " " + address+ " " + city+ " " + state+ " " + zipcode + country);
        return "redirect:/admin";
    }




    @RequestMapping(value = "listLocations", method = RequestMethod.GET)
    public String LocationList(Model model){
        model.addAttribute("locationsKey", locationDAO.getAllLocations());

        return "listLocations";

    }

    // this is to code for read functionality  for 1 user ( The R in CRUD)
    @RequestMapping(value = "/modify", method=RequestMethod.GET)
    public String getToModifyLocation(Model model,@RequestParam String id){

        Location location = locationDAO.findLocation(id,null,null,null,null,null );
        model.addAttribute("l",location);
        return "modifyLocation";

    };

   // this is to code for UPDATE functionality  for 1 location ( The U in CRUD)
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyLocation(Model model,
                                 @RequestParam String id,
                                 @RequestParam String address,
                                 @RequestParam String city,
                                 @RequestParam String state,
                                 @RequestParam String zipcode,
                                 @RequestParam String country

    ){

        System.out.println("l"+id);
        Location location = new Location(id,address, city,state,zipcode,country);


        locationDAO.updateLocation(location );

        return "redirect:/admin";
    }

    // this is to code for DELETE functionality  for 1 user ( The U in CRUD)
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCar(Model model,
                            @RequestParam String id
    ){

        System.out.println("l"+id);


      locationDAO.deleteLocation(id);

        return "redirect:/listLocations";
    }








}
