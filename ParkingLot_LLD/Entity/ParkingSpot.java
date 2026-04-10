package ParkingLot_LLD.Entity;

public class ParkingSpot {
    private final String spotId;
    private boolean isFree = true;

    public void OccupySpot(){
        isFree = false;
    }

    public void ReleaseSpot(){
        isFree = true;
    }

    public boolean isSpotFree(){
        return isFree;
    }

    public String getSpotId(){
        return spotId;
    }
}
