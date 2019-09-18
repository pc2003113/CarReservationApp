package com.eride.CarReservationApp.Models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

    private String userid;
    private String password;
    private String fname;
    private String lname;
    private String email;
    private boolean admin;

    public User(String userid, String password, String fname, String lname, String email,boolean admin) {
        this.userid=userid;
        this.password=password;
        this.fname=fname;
        this.lname=lname;
        this.email=email;
        this.admin=admin;
    }
    public User(String year, String make, String vehicleModel, String vehicleType) {

    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid=userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname=fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname=lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin=admin;
    }
}
