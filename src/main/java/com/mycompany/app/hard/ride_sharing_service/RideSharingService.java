package com.mycompany.app.hard.ride_sharing_service;

import java.util.HashMap;
import java.util.Map;

public class RideSharingService {
    private static RideSharingService instance;
    private Map<String, Passenger> passengers;

    private RideSharingService() {
        passengers = new HashMap<String, Passenger>();
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

    public void removePassenger(String passengerId) {
        passengers.remove(passengerId);
    }
}
