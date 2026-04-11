package ParkingLot_LLD.spotManagers;
import ParkingLot_LLD.Entity.ParkingSpot;
import ParkingLot_LLD.LookupStrategy.ParkingSpotLookupStrategy;
import java.util.concurrent.locks.ReentrantLock;
import java.util.List;

public abstract class ParkingSpotManager{
    protected final List<ParkingSpot> spots;
    protected final ParkingSpotLookupStrategy strategy;
    private final ReentrantLock lock = new ReentrantLock(true);

    public ParkingSpotManager(List<ParkingSpot> spots,  ParkingSpotLookupStrategy strategy){
        this.spots = spots;
        this.strategy = strategy;
    }

    public ParkingSpot park(){
        lock.lock();
        try{
            ParkingSpot spot = strategy.selectSpot(spots);
            if(spot != null){
                spot.OccupySpot();
                return spot;
            }
            return null;
        } finally{
            lock.unlock();
        }
    }

    public void unPark(ParkingSpot spot){
        lock.lock();
        try{
            spot.ReleaseSpot();
        } finally{
            lock.unlock();
        }
    }

    public boolean hasFreeSpot(){
        lock.lock();
        try{
            for(ParkingSpot spot : spots){
                if(spot.isSpotFree()){
                    return true;
                }
            }
            return false;
        } finally{
            lock.unlock();
        }
    }
}