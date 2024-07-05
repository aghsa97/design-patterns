package com.mycompany.app.easy.parking_lot.vechicles_type;


public class Vehicle {
    private String plate;
    private VehiclesType type;

    public Vehicle(String plate, VehiclesType type) {
        this.plate = plate;
        this.type = type;
    }

    public VehiclesType getType() {
        return type;
    }

    public String getPlate() {
        return plate;
    }
}
