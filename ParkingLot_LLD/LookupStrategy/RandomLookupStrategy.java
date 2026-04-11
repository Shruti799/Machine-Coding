package ParkingLot_LLD.LookupStrategy;
import ParkingLot_LLD.Entity.ParkingSpot;
import java.util.List;

public class RandomLookupStrategy implements ParkingSpotLookupStrategy{
    public ParkingSpot selectSpot(List<ParkingSpot> spots){
        for(ParkingSpot spot : spots){
            if(spot.isSpotFree()){
                return spot;
            }
        }
        return null;
    }
}
