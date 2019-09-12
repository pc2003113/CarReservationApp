package com.eride.CarReservationApp.Controllers;

import com.eride.CarReservationApp.Models.RegisterModel;
import com.eride.CarReservationApp.Models.User;
import com.eride.CarReservationApp.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.UserDataHandler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// this module is specific to CRUD of user


@Controller
@RequestMapping("user")
public class UserController {
    public static ArrayList<User>users;
    @Autowired
    private UserDAO userDAO;

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
    //user create functionality for 1 user ( the c in CRUD)
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


        User u = new User(userid, password,fname,lname,email,false);

        userDAO.addUser(u);

        System.out.println("Saved it..." + userid + " " + password+ " " + fname+ " " + lname+ " " +email+ " ");
        return "userInfo";
    }

    // this is to code for read functionality  for all users
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String registeredUserList(Model model){
        model.addAttribute("userskey", userDAO.getAllUsers());

        return "usersList";

    }
    // this is to code for read functionality  for 1 user ( The R in CRUD)
    @RequestMapping(value = "/modify", method=RequestMethod.GET)
    public String getToModifyUser(Model model,@RequestParam String userid){

       User u = userDAO.findUser(userid,null,null,null);
        model.addAttribute("u",u);
        return "modifyUser";

    };

    // this is to code for UPDATE functionality  for 1 user ( The U in CRUD)
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyUser(Model model,
                                        @RequestParam String userid,
                                        @RequestParam String password,
                                        @RequestParam String fname,
                                        @RequestParam String lname,
                                        @RequestParam String email){

        System.out.println("u"+userid);
        User u = new User(userid, password,fname,lname,email,false);


        userDAO.updateUser(u);

        return "redirect:/admin";
    }

    // this is to code for DELETE functionality  for 1 user ( The U in CRUD)
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(Model model,
                             @RequestParam String userid
                          ){

        System.out.println("u"+userid);


        userDAO.deleteUser(userid);

        return "redirect:/admin";
    }




}
