package com.mycompany.app.hard.ride_sharing_service;

public class Ride {
    private final String id;
    private final Passenger passenger;
    private Driver driver;
    private RideStatus status;
    private String destination;

    public enum RideStatus {
        REQUESTED,
        ACCEPTED,
        IN_PROGRESS,
        COMPLETED,
        CANCELLED
    }

    public Ride(String id, Passenger passenger, String destination) {
        this.id = id;
        this.passenger = passenger;
        this.destination = destination;
        this.status = RideStatus.REQUESTED;
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

    public RideStatus getStatus() {
        return status;
    }

    public String getDestination() {
        return destination;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }
}
