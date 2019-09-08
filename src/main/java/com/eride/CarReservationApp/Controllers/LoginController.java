package com.eride.CarReservationApp.Controllers;


import com.eride.CarReservationApp.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
// Managining the navigation of the user( could be customer or Admin)
// this controller has one get method to display the login page and 2 post methods for the type of users namely, the customer and the administrator
// if customer,  will take the user to the booking screen ( under construction) and if administrator will take to admin screen

@Controller
@RequestMapping(value ="login")
public class LoginController {


    @RequestMapping(value="", method=RequestMethod.GET)
    public String displaylogin(Model model) {
        return "login";

    }

    @RequestMapping(value="/customer", method=RequestMethod.POST)
    public String submitLoginCustomer(Model model,
                              @RequestParam String userid,
                              @RequestParam String password) {
        for(int i = 0; i <UserController.users.size(); i++){

            User u= UserController.users.get(i);
            if (u.getUserid().equals(userid) && u.getPassword().equals(password)) {

                return "RentalBooking";

            }

        }


        // no match found error logic follows
        model.addAttribute("message","invalid login, please try again");
        return "login";


    }


    // for admin
    @RequestMapping(value="/admin", method=RequestMethod.POST)
    public String submitLoginAdmin(Model model,
                              @RequestParam String userid,
                              @RequestParam String password) {
        for(int i = 0; i <UserController.users.size(); i++){

            User u= UserController.users.get(i);
            if (u.getUserid().equals(userid) && u.getPassword().equals(password) && u.isAdmin()) {

                return "admin";

            }

        }


        // no match found error logic follows
        model.addAttribute("message","invalid login, please try again");
        return "login";


    }




}
