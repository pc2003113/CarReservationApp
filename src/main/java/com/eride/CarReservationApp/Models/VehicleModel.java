package com.eride.CarReservationApp.Models;

public class VehicleModel {
    private String year;
    private String make;
    private String model;
    private String type;


    public VehicleModel(String year, String make, String model, String type) {
        this.year=year;
        this.make=make;
        this.model=model;
        this.type=type;
    }
    public VehicleModel() {}

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

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model=model;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type=type;
        }



}


