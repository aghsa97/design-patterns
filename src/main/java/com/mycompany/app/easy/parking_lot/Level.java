package com.mycompany.app.easy.parking_lot;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.app.easy.parking_lot.vechicles_type.Vehicle;

public class Level {
    private final int floor;
    private final List<Spot> spots;

    public Level(int floor, int spots){
        this.floor = floor;
        this.spots = new ArrayList<>(spots);
        
        for (int i = 0; i < spots; i++) {
            this.spots.add(new Spot(i));
        }
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public int countAvailableSpots() {
        int count = 0;
        System.out.println("Level " + floor + " Availability:");

        for (Spot spot : spots) {
            if (spot.isAvailable()) {
                count++;
                System.out.println("Spot " + spot.getNumber() + ": Available");
            }
        }

        return count;
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (Spot spot : spots) {
            if (spot.isAvailable() && spot.getSpotType() == vehicle.getType()) {
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle) {
        for (Spot spot : spots) {
            if (!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle)) {
                spot.unparkVehicle();
                return true;
            }
        }
        return false;
    }
    
}
