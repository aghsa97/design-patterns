package com.mycompany.app.hard.ride_sharing_service;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.mycompany.app.hard.ride_sharing_service.Driver.DriverStatus;
import com.mycompany.app.hard.ride_sharing_service.Ride.RideStatus;

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

    private void notifyDrivers(Ride ride) {
        for (Driver driver : drivers.values()) {
            if (driver.getStatus() == DriverStatus.AVAILABLE) {
                System.out.println("Notifying driver: " + driver.getName() + " about ride request: " + ride.getId());
            }
        }
    }

    
    public static synchronized RideSharingService getInstance() {
        if (instance == null) {
            instance = new RideSharingService();
        }
        return instance;
    }

    public Map<String, Driver> getDrivers() {
        return drivers;
    }

    public Map<String, Passenger> getPassengers() {
        return passengers;
    }

    public Map<String, Ride> getRides() {
        return rides;
    }

    public Queue<Ride> getRequestedRides() {
        return requestedRides;
    }
    
    public void addPassenger(Passenger passenger) {
        passengers.put(passenger.getId(), passenger);
    }

    public void addDriver(Driver driver) {
        drivers.put(driver.getId(), driver);
    }

    public void requestRide(Passenger passenger, String destination) {
        Ride requestedRide = new Ride(generateRideId(), passenger, destination);
        requestedRides.offer(requestedRide);
        notifyDrivers(requestedRide);
    }

    public synchronized void acceptRide(Ride ride, Driver driver) {
        if (driver.getStatus() == DriverStatus.AVAILABLE) {
            ride.setDriver(driver);
            rides.put(ride.getId(), ride);
            ride.setStatus(RideStatus.ACCEPTED);
            driver.setStatus(DriverStatus.BUSY);

            // TODO: Notify passenger
        }
    }

    public synchronized void cancelRide(Ride ride) {
        if (ride.getStatus() == RideStatus.REQUESTED || ride.getStatus() == RideStatus.ACCEPTED) {
            ride.setStatus(RideStatus.CANCELLED);
            if (ride.getDriver() != null) {
                ride.getDriver().setStatus(DriverStatus.AVAILABLE);
                ride.setDriver(null);
            }

            // TODO: Notify passenger
            // TODO: Notify driver
        }
    }

    public void startRide(Ride ride) {
        if (ride.getStatus() == RideStatus.ACCEPTED) {
            ride.setStatus(RideStatus.IN_PROGRESS);

            // TODO: Notify passenger
        }
    }

    public void completeRide(Ride ride) {
        if (ride.getStatus() == RideStatus.IN_PROGRESS) {
            ride.setStatus(RideStatus.COMPLETED);
            ride.getDriver().setStatus(DriverStatus.AVAILABLE);

            // TODO: Notify passenger
            // TODO: Notify driver
        }
    }
}
