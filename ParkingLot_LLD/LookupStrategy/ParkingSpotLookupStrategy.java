package ParkingLot_LLD.LookupStrategy;
import java.util.List;
import ParkingLot_LLD.Entity.ParkingSpot;

public interface ParkingSpotLookupStrategy {
    ParkingSpot selectSpot(List<ParkingSpot> spots);
}
