package com.mycompany.app.easy.parking_lot;

import com.mycompany.app.easy.parking_lot.vechicles_type.Vehicle;
import com.mycompany.app.easy.parking_lot.vechicles_type.VehiclesType;

public class Spot {
    private int number;
    private VehiclesType type;
    private Vehicle parkedVehicle;

    public Spot(int number) {
        this.number = number;
        this.type = VehiclesType.CAR; // as default
    }
    
    public int getNumber() {
        return number;
    }

    public VehiclesType getSpotType() {
        return type;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setVehiclesType(VehiclesType type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        if (isAvailable() && vehicle.getType() == type) {
            parkedVehicle = vehicle;
        } else {
            throw new IllegalArgumentException("Invalid vehicle type or spot already occupied.");
        }
    }

    public synchronized void unparkVehicle() {
        parkedVehicle = null;
    }

}
