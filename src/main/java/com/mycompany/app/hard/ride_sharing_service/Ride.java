package com.mycompany.app.hard.ride_sharing_service;

public class Ride {
    private final String id;
    private final Passenger passenger;
    private Driver driver;
    private RideStatus status;
    private String destination;
    private String startPoint;
    private RideType type;
    private double fare;

    public enum RideStatus {
        REQUESTED,
        ACCEPTED,
        IN_PROGRESS,
        COMPLETED,
        CANCELLED
    }

    public enum RideType {
        REGULAR,
        PREMIUM
    }

    public Ride(String id, Passenger passenger, String startPoint, String destination, RideType type, double fare) {
        this.id = id;
        this.type = type;
        this.startPoint = startPoint;
        this.passenger = passenger;
        this.destination = destination;
        this.status = RideStatus.REQUESTED;
        this.fare = fare;
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

    public String getStartPoint() {
        return startPoint;
    }

    public RideType getType() {
        return type;
    }

    public double getFare() {
        return fare;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}
