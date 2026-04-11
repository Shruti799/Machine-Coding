package ParkingLot_LLD.parkinglot;
import java.util.Map;

import ParkingLot_LLD.Entity.ParkingSpot;
import ParkingLot_LLD.Entity.Vehicle;
import ParkingLot_LLD.enums.VehicleType;
import ParkingLot_LLD.spotManagers.ParkingSpotManager;

public class ParkingLevel {
    private final int levelNumber;
    private final Map<VehicleType, ParkingSpotManager> managers;

    public ParkingLevel(int levelNumber, Map<VehicleType, ParkingSpotManager> managers){
        this.levelNumber = levelNumber;
        this.managers = managers;
    }

    public boolean hasAvailability(VehicleType vehicleType){
        ParkingSpotManager manager = managers.get(vehicleType);
        return manager != null && manager.hasFreeSpot();
    }

    public ParkingSpot park(VehicleType vehicleType){
        ParkingSpotManager manager = managers.get(vehicleType);
        if(manager == null){
            throw new IllegalArgumentException("No parking manager available for " + vehicleType);
        }
        return manager.park();
    }

    public void unPark(Vehicle vehicleType, ParkingSpot parkingSpot){
        ParkingSpotManager manager = managers.get(vehicleType);
        if(manager!=null){
            manager.unPark(parkingSpot);
        }
    }

    public int getLevelNumber(){
        return levelNumber;
    }
}
