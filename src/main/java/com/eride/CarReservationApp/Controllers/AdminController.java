package com.eride.CarReservationApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller displays the admin home page which has link to different pages
 *
 */



@Controller
public class AdminController {

    @RequestMapping(value = "/admin", method=RequestMethod.GET)
    public String showAdmin(){
        return "admin";
    }


}
