package com.mycompany.app.hard.ride_sharing_service;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.mycompany.app.hard.ride_sharing_service.Driver.DriverStatus;

public class RideSharingService {
    private static RideSharingService instance;
    private Map<String, Ride> rides;
    private Map<String, Driver> drivers;
    private Map<String, Passenger> passengers;
    private Queue<Ride> requestedRides;


    private RideSharingService() {
        rides = new HashMap<String, Ride>();
        drivers = new HashMap<String, Driver>();
        passengers = new HashMap<String, Passenger>();
        requestedRides = new ConcurrentLinkedQueue<Ride>();
    }

    private String generateRideId() {
        return String.valueOf((int) (System.currentTimeMillis() / 1000));
    }

    public static synchronized RideSharingService getInstance() {
        if (instance == null) {
            instance = new RideSharingService();
        }
        return instance;
    }

    public void addPassenger(Passenger passenger) {
        passengers.put(passenger.getId(), passenger);
    }

    public void addDriver(Driver driver) {
        drivers.put(driver.getId(), driver);
    }

    public void requestRide(Passenger passenger) {
        Ride requestedRide = new Ride(generateRideId(), passenger);
        requestedRides.offer(requestedRide);
    }

    public void acceptRide(Ride ride, Driver driver) {
        ride.fulfill();
        ride.setDriver(driver);
        rides.put(ride.getId(), ride);
        driver.setStatus(DriverStatus.BUSY);
    }
}
