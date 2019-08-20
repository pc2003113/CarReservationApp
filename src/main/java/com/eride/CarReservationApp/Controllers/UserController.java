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
    public static ArrayList<User>users;

    public UserController() {
        users = new ArrayList<User>();
        users.add(new User("Priyacjose","12345","Priya","Jose","p.c@gmail.com",true));
        users.add(new User("Josecjose","45678","Jose","Jose","j.j@gmail.com",false));


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
                                        @RequestParam String password,
                                        @RequestParam String fname,
                                        @RequestParam String lname,
                                        @RequestParam String email){
        model.addAttribute("userid",userid);
        model.addAttribute("password",password);
        model.addAttribute("fname",fname);
        model.addAttribute("lname",lname);
        model.addAttribute("email",email);



        System.out.println("Saved it..." + userid + " " + password+ " " + fname+ " " + lname+ " " +email+ " ");

        users.add(new User(userid, password,fname,lname,email,false));
        return "userInfo";




    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String registeredUserList(Model model){
        model.addAttribute("userskey",users);

        return "usersList";




    }


}
