package com.mycompany.app.easy.parking_lot;

import java.util.List;

import com.mycompany.app.easy.parking_lot.vechicles_type.Car;
import com.mycompany.app.easy.parking_lot.vechicles_type.Motorcycle;
import com.mycompany.app.easy.parking_lot.vechicles_type.Truck;
import com.mycompany.app.easy.parking_lot.vechicles_type.Vehicle;
import com.mycompany.app.easy.parking_lot.vechicles_type.VehiclesType;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstans();
        parkingLot.addLevel(new Level(1, 5));
        parkingLot.addLevel(new Level(2, 5));

        Vehicle volvo = new Car("ABC123");
        Vehicle saab = new Truck("ABC234");
        Vehicle suzuki = new Motorcycle("ABC345");

        List<Level> levels = parkingLot.getLevels();
        
        levels.get(0).getSpots().get(1).setVehiclesType(VehiclesType.TRUCK);
        levels.get(1).getSpots().get(2).setVehiclesType(VehiclesType.MOTORCYCLE);

        parkingLot.parkVehicle(volvo);
        parkingLot.parkVehicle(saab);
        parkingLot.parkVehicle(suzuki);

        parkingLot.unparkVehicle(suzuki);

        levels.get(0).countAvailableSpots();
        levels.get(1).countAvailableSpots();

        }
}
