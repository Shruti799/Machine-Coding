package ParkingLot_LLD.spotManagers;
import java.util.List;

import ParkingLot_LLD.Entity.ParkingSpot;
import ParkingLot_LLD.LookupStrategy.ParkingSpotLookupStrategy;

public class FourWheelerSpotManager extends ParkingSpotManager{
    public FourWheelerSpotManager(List<ParkingSpot> spots, ParkingSpotLookupStrategy strategy){
        super(spots,strategy);
    }
}
