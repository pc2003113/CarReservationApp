package com.eride.CarReservationApp.Controllers;

import com.eride.CarReservationApp.Models.User;
import com.eride.CarReservationApp.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import java.security.SecureRandom;

// Managining the navigation of the user( could be customer or Admin)
// this controller has one get method to display the login page and 2 post methods for the type of users namely, the customer and the administrator
// if customer,  will take the user to the booking screen ( under construction) and if administrator will take to admin screen

@Controller
@RequestMapping(value ="login")
public class LoginController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value="", method=RequestMethod.GET)
    public String displaylogin(Model model) {
        return "login";

    }
    @RequestMapping(value="/customer", method=RequestMethod.POST)
    public String submitLoginCustomer(Model model,
                              @RequestParam String userid,
                              @RequestParam String password) {

        String userInputPW=getHash(password);

        User u =userDAO.findUser(userid,null,null,null);

        System.out.println(u.getPassword());
        System.out.println(userInputPW);

            if (u!=null && u.getPassword().equals(userInputPW)) {

                return "RentalBooking";
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

        String userInputPW=getHash(password);
        {
            User u=userDAO.findUser(userid, null, null, null);

            System.out.println(u.getPassword());
            System.out.println(userInputPW);

            if (u != null && u.getPassword().equals(userInputPW) && u.isAdmin()) {

                return "admin";

            }
            // no match found error logic follows
            model.addAttribute("message", "invalid login, please try again");
            return "login";
        }
    }

    public static String getHash(String password) {
        String algorithm="SHA-512";
        byte[]inputBytes=password.getBytes();
        String hashValue="";
        try {
            MessageDigest messageDigest=MessageDigest.getInstance(algorithm);
            messageDigest.update(inputBytes);
            byte[] digestedBytes=messageDigest.digest();
            hashValue=DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();

        } catch (Exception e) {

        }
        return hashValue;
    }

}
