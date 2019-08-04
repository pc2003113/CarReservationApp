package com.eride.CarReservationApp.Models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RegisterModel {
    private String currentDate;


    public void populateCurrentDate() {

        SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
        String cd=sdf.format(new Date());
        this.currentDate=cd;
        //return currentDate;
    }
    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate=currentDate;
    }


}
