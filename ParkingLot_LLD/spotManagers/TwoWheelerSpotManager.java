package ParkingLot_LLD.spotManagers;

import ParkingLot_LLD.Entity.ParkingSpot;
import ParkingLot_LLD.LookupStrategy.ParkingSpotLookupStrategy;
import java.util.List;

public class TwoWheelerSpotManager extends ParkingSpotManager{
    public TwoWheelerSpotManager(List<ParkingSpot> spots, ParkingSpotLookupStrategy strategy){
        super(spots,strategy);
    }
}
