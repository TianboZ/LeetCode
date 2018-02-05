package parkingLotOOD;

public class ParkingLot {
    private  final Level[] levels;

    public ParkingLot(int numOfLevels, int numOfSpotPerLevel) {
        levels = new Level[numOfLevels];
        for (int i = 0; i < levels.length; i++) {
            levels[i] = new Level(numOfSpotPerLevel);
        }
    }

    public boolean hasSpot(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.hasSpot(vehicle)) {
                if (level.park(vehicle)) { // parking
                    return true;
                }
            }
        }
        return false;
    }

    public boolean leave(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.leave(vehicle)) { // leaving
                return true;
            }
        }
        return false;
    }
}
