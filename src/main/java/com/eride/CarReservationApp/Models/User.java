package com.eride.CarReservationApp.Models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

    private String currentDate;
    private String userid;
    private String username;
    private String passid;
    private String address;

    public User(String userid, String username, String passid, String address) {
        this.userid=userid;
        this.username=username;
        this.passid=passid;
        this.address=address;
    }
    public User() {

    }

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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid=userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public String getPassid() {
        return passid;
    }

    public void setPassid(String passid) {
        this.passid=passid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address=address;
    }


}
