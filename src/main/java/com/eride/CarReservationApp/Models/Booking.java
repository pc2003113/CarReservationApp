package com.eride.CarReservationApp.Models;

public class Booking {
    private int ID;
    private String branchID;
    private String startDate;
    private String endDate;
    private String vehicleType;


    public Booking(int ID,String branchID, String startDate, String endDate, String vehicleType) {
        this.ID=ID;
        this.branchID=branchID;
        this.startDate=startDate;
        this.endDate=endDate;
        this.vehicleType=vehicleType;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID=ID;
    }

    public Booking() {}

    public String getBranchID() {
        return branchID;
    }

    public void setBranchID(String bookingID) {
        this.branchID=bookingID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate=startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate=endDate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType=vehicleType;
    }
}
