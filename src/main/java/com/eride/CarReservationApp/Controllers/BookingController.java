package com.eride.CarReservationApp.Controllers;

import com.eride.CarReservationApp.Models.Booking;
import com.eride.CarReservationApp.Models.Car;
import com.eride.CarReservationApp.Models.Location;
import com.eride.CarReservationApp.dao.BookingDAO;
import com.eride.CarReservationApp.dao.CarDAO;
import com.eride.CarReservationApp.dao.LocationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Controller
public class BookingController {

    @Autowired
    private LocationDAO locationDAO;
    @Autowired
    private BookingDAO bookingDAO;

    @RequestMapping(value = "addBooking", method=RequestMethod.GET)
    public String admin(Model model){
        List<Location> locList=locationDAO.getAllLocations();
        model.addAttribute("LocationsKey", locList);

        return "addBooking";

    }

    @RequestMapping(value = "addBooking", method = RequestMethod.POST)
    public String saveNewCar(Model model,
                             @RequestParam String branchID,
                             @RequestParam String startDate,
                             @RequestParam String endDate,
                             @RequestParam String vehicleType
    )
    {
        Random r= new Random();

        Booking br=new Booking(r.nextInt(), branchID, startDate, endDate, vehicleType);

        bookingDAO.addBookings(br);

        System.out.println("Saved it..." + br.getID() + branchID + " " + startDate + " " + endDate + " " + vehicleType);
        return "redirect:/bookingConfirmed?bookingID="+ br.getID(); // the randomID generated along with this confirmation
        // is local hence a query parameter is required to used this id to display the informarion just created

    }
    @RequestMapping(value = "bookingConfirmed", method=RequestMethod.GET)
    public String confirmedBooking(Model model,
                                   @RequestParam String bookingID){

        model.addAttribute("confirmationKey", bookingID);

        return "bookingConfirmation";

    }




}
