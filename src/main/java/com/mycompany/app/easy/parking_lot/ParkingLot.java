package com.mycompany.app.easy.parking_lot;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.app.easy.parking_lot.vechicles_type.Vehicle;

public class ParkingLot {
    private static ParkingLot INSTANS;
    private final List<Level> levels;

    private ParkingLot() {
        this.levels = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstans() {
        if (INSTANS == null) {
            INSTANS = new ParkingLot();
        }
        return INSTANS;
    }

    public void addLevel(Level level) {
        this.levels.add(level);
    }

    public List<Level> getLevels() {
        return levels;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.unparkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }
}
