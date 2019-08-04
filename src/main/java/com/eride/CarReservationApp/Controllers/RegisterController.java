package com.eride.CarReservationApp.Controllers;

import com.eride.CarReservationApp.Models.RegisterModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegisterController {
    @RequestMapping(value = "register", method=RequestMethod.GET)
    public String register(Model model){
        RegisterModel rm= new RegisterModel();
        rm.populateCurrentDate();
          model.addAttribute("RegisterModel",rm);
    return "register";
    };


}
