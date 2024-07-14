package com.mycompany.app.hard.ride_sharing_service;

import com.mycompany.app.hard.ride_sharing_service.Ride.RideType;

public class Main {
    public static void main( String[] args )
    {
        System.out.println("Hello world!");
        RideSharingService rideService = RideSharingService.getInstance();

        // Create passengers
        Passenger passenger1 = new Passenger("1", "John Doe");
        Passenger passenger2 = new Passenger("2", "Jane Smith");
        rideService.addPassenger(passenger1);
        rideService.addPassenger(passenger2);

        // Create drivers
        Driver driver1 = new Driver("1", "Alice Johnson");
        Driver driver2 = new Driver("2", "Bob Williams");
        rideService.addDriver(driver1);
        rideService.addDriver(driver2);

        // Passenger 1 requests a ride
        rideService.requestRide(passenger1, passenger1.getLocation(), "someDestination", RideType.REGULAR);

        // Driver 1 accepts the ride
        Ride ride1 = rideService.getRequestedRides().poll();
        rideService.acceptRide(ride1, driver1);

        // Start the ride
        rideService.startRide(ride1);
        
        // check ride fare before completing
        System.out.println("ride 1 fare: " + ride1.getFare() + " passenger 1: " + passenger1.getWallet() + " driver 1: " + driver1.getWallet());

        // Complete the ride
        rideService.completeRide(ride1);

        // Passenger 2 requests a ride
        rideService.requestRide(passenger2, passenger2.getLocation(), "someDestination", RideType.PREMIUM);

        // Driver 2 accepts the ride
        Ride ride2 = rideService.getRequestedRides().poll();
        rideService.acceptRide(ride2, driver2);

        // Passenger 2 cancels the ride
        rideService.cancelRide(ride2);

        // check ride fare after compeleting
        System.out.println("ride 1 fare: " + ride1.getFare() + " passenger 1: " + passenger1.getWallet() + " driver 1: " + driver1.getWallet());
    } 
}
