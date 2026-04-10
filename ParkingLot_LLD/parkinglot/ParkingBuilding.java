package ParkingLot_LLD.parkinglot;

import ParkingLot_LLD.Entity.Vehicle;
import ParkingLot_LLD.Entity.ParkingSpot;
import java.util.List;

public class ParkingBuilding {
    List<ParkingLevel> parkingLevels;
    
    public ParkingBuilding(List<ParkingLevel> parkingLevels){
        this.parkingLevels = parkingLevels;
    }

    public Ticket allocateTicket(Vehicle vehicle){
        for(auto level : parkingLevels){
            if(level.hasAvailability(vehicle.getVehicleType())){
                ParkingSpot spot = level.park(vehicle.getVehicleType());
                if(spot != null){
                    Ticket ticket = new Ticket(vehicle,level,spot);
                    System.out.println("Parking alloted at level: " + level.getLevelNumber() + "spot: " + spot.getSpotId());
                    return ticket;
                }
            }
        }
    }
    
    public deallocateTicket(Vehicle vehicle){
        
    }

}
