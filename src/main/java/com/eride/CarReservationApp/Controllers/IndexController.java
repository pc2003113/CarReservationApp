package com.eride.CarReservationApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This is the app's home page which describes the different functionality the app is capable of
 */
@Controller
public class IndexController {

    @RequestMapping(value = "", method=RequestMethod.GET)
    public String showIndex(){
        return "index";
    }

}
