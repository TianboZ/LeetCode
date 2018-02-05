package parkingLotOOD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level {
    private final List<ParkingSpot> spotList;

    Level (int numOfSpots) {
        List<ParkingSpot> list = new ArrayList<>(numOfSpots);
        int i = 0;
        for (i = 0; i < numOfSpots / 2; i++) {
            list.add(new ParkingSpot(VehicleSize.Compact));
        }
        for (i = i; i < numOfSpots; i++) {
            list.add(new ParkingSpot(VehicleSize.Large));
        }
        spotList = Collections.unmodifiableList(list);
    }

    boolean hasSpot(Vehicle vehicle) {
        for (ParkingSpot spot : spotList) {
            if(spot.fit(vehicle)) {
                return true;
            }
        }
        return false;
    }

    boolean park (Vehicle vehicle) {
        for (ParkingSpot spot : spotList) {
            if (spot.fit(vehicle)) {
                spot.park(vehicle); // parking
                return true;
            }
        }
        return false;
    }

    boolean leave (Vehicle vehicle) {
        for (ParkingSpot spot : spotList) {
            if (spot.getCurrentVehicle() == vehicle) {
                spot.leave(); // leaving
                return true;
            }
        }
        return false;
    }
}

