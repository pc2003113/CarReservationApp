package com.eride.CarReservationApp.Controllers;

import com.eride.CarReservationApp.Models.RegisterModel;
import com.eride.CarReservationApp.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("user")
public class UserController {
    static ArrayList<User>users;

    public UserController() {
        users = new ArrayList<User>();
        users.add(new User("Priyacjose","Priya","12345","1234 Main Street"));
        users.add(new User("Adamcjose","Adam","67890","1234 Main Street"));

    }



    @RequestMapping(value = "register", method=RequestMethod.GET)
    public String register(Model model){
        RegisterModel rm= new RegisterModel();
        rm.populateCurrentDate();
        model.addAttribute("RegisterModel",rm);
    return "register";
    };

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String saveRegisterationData(Model model,
                                        @RequestParam String userid,
                                        @RequestParam String passid,
                                        @RequestParam String username,
                                        @RequestParam String address){
        model.addAttribute("userid",userid);
        model.addAttribute("passid",passid);
        model.addAttribute("username",username);
        model.addAttribute("address",address);



        System.out.println("Saved it..." + userid + " " + passid+ " " + username+ " " + address);

        users.add(new User(userid, username,passid,address));
        return "userInfo";




    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String registeredUserList(Model model){
        model.addAttribute("userskey",users);

        return "usersList";




    }


}
