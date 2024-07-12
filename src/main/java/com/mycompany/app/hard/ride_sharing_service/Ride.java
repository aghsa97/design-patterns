package com.mycompany.app.hard.ride_sharing_service;

public class Ride {
    private final String id;
    private final Passenger passenger;
    private Driver driver;
    private boolean fulfilled;

    public Ride(String id, Passenger passenger) {
        this.id = id;
        this.passenger = passenger;
        this.fulfilled = false;
    }

    public String getId() {
        return id;
    }
    
    public Passenger getPassenger() {
        return passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public boolean getFulfilled() {
        return fulfilled;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void fulfill() {
        this.fulfilled = true;
    }

    public void neglect() {
        this.fulfilled = false;
    }
}
