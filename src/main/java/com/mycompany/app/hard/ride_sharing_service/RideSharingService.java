package com.mycompany.app.hard.ride_sharing_service;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.mycompany.app.hard.ride_sharing_service.Driver.DriverStatus;
import com.mycompany.app.hard.ride_sharing_service.Ride.RideStatus;
import com.mycompany.app.hard.ride_sharing_service.Ride.RideType;

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

    private void notifyDriver(Ride ride) {
        Driver driver = ride.getDriver();
        if (driver != null) {
            String message = "";
            switch (ride.getStatus()) {
                case COMPLETED:
                    message = "Ride Completed.";
                    break;
                case CANCELLED:
                    message = "Ride canceled.";
                    break;
                default:
                    break;
            }
            System.out.println("Notifying driver: " + driver.getName() + " - " + message);
        }
    }

    private void notifyPassenger(Ride ride) {
        Passenger passenger = ride.getPassenger();
        String message = "";
        if (passenger != null) {
            switch (ride.getStatus()) {
                case REQUESTED:
                    message = passenger.getName() + " requested a ride";
                    break;
                case ACCEPTED:
                    message = "Your ride has been accepted by driver: " + ride.getDriver().getName();
                    break;
                case IN_PROGRESS:
                    message = "Your ride is in progress.";
                    break;
                case COMPLETED:
                    message = "Your ride has been completed.";
                    break;
                case CANCELLED:
                    message = "Your ride has been cancelled.";
                    break;
            }
            System.out.println("Notifying passenger: " + passenger.getName() + " - " + message);
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

    public void requestRide(Passenger passenger, String pickup, String destination, RideType type) {
        Ride requestedRide = new Ride(generateRideId(), passenger,pickup, destination, type);
        requestedRides.offer(requestedRide);
        notifyDrivers(requestedRide);
    }

    public synchronized void acceptRide(Ride ride, Driver driver) {
        if (driver.getStatus() == DriverStatus.AVAILABLE) {
            ride.setDriver(driver);
            rides.put(ride.getId(), ride);
            ride.setStatus(RideStatus.ACCEPTED);
            driver.setStatus(DriverStatus.BUSY);
            notifyPassenger(ride);
        }
    }

    public synchronized void cancelRide(Ride ride) {
        if (ride.getStatus() == RideStatus.REQUESTED || ride.getStatus() == RideStatus.ACCEPTED) {
            ride.setStatus(RideStatus.CANCELLED);
            if (ride.getDriver() != null) {
                ride.getDriver().setStatus(DriverStatus.AVAILABLE);
                ride.setDriver(null);
            }
            notifyDriver(ride);
            notifyPassenger(ride);
        }
    }

    public void startRide(Ride ride) {
        if (ride.getStatus() == RideStatus.ACCEPTED) {
            ride.setStatus(RideStatus.IN_PROGRESS);
            notifyPassenger(ride);
        }
    }

    public void completeRide(Ride ride) {
        if (ride.getStatus() == RideStatus.IN_PROGRESS) {
            ride.setStatus(RideStatus.COMPLETED);
            ride.getDriver().setStatus(DriverStatus.AVAILABLE);
            notifyDriver(ride);
            notifyPassenger(ride);
        }
    }
}
