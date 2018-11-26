package parkingLotOOD;

public class ParkingSpot {
    private final VehicleSize size;
    private Vehicle currentVehicle;

    ParkingSpot(VehicleSize size) {
        this.size = size;
    }

    boolean fit(Vehicle vehicle) {
        return currentVehicle == null && size.getSize() >= vehicle.getSize().getSize();
    }

    void park(Vehicle vehicle) {
        currentVehicle = vehicle;
    }

    void leave() {
        currentVehicle = null;
    }

    Vehicle getCurrentVehicle() {
        return currentVehicle;
    }
}