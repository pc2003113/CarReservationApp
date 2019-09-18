package com.eride.CarReservationApp.Models;

public class Car {


    private int id;
    private String year;
    private String make;
    private String vehicleModel;
    private String vehicleType;


    public Car(int id, String year, String make, String vehicleModel, String vehicleType) {
        this.id=id;
        this.year=year;
        this.make=make;
        this.vehicleModel=vehicleModel;
        this.vehicleType=vehicleType;
    }
    public Car() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getYear() {
            return year;
        }



        public void setYear(String year) {
            this.year=year;
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make=make;
        }

        public String getVehicleModel() {return vehicleModel;}

        public void setVehicleModel(String vehicleModel) {
            this.vehicleModel=vehicleModel;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public void setvehicleType(String type) {
            this.vehicleType=type;
        }



}


