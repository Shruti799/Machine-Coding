package ParkingLot_LLD.parkinglot;

import ParkingLot_LLD.Entity.Vehicle;
import ParkingLot_LLD.Entity.ParkingSpot;
import ParkingLot_LLD.Ticket;
import java.util.List;

public class ParkingBuilding {
    List<ParkingLevel> parkingLevels;
    
    public ParkingBuilding(List<ParkingLevel> parkingLevels){
        this.parkingLevels = parkingLevels;
    }

    public Ticket allocateTicket(Vehicle vehicle){
        for(ParkingLevel level : parkingLevels){
            if(level.hasAvailability(vehicle.getVehicleType())){
                ParkingSpot spot = level.park(vehicle.getVehicleType());
                if(spot != null){
                    Ticket ticket = new Ticket(vehicle,level,spot);
                    System.out.println("Parking alloted at level: " + level.getLevelNumber() + "spot: " + spot.getSpotId());
                    return ticket;
                }
            }
        }
        throw new RuntimeException("Parking Full");
    }
    
    public void release(Ticket ticket){
        ticket.getParkingLevel().unPark(ticket.getVehicle().getVehicleType(), ticket.getParkingSpot());
    }

}
