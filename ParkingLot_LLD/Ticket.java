package ParkingLot_LLD;
import ParkingLot_LLD.Entity.ParkingSpot;
import ParkingLot_LLD.Entity.Vehicle;
import ParkingLot_LLD.parkinglot.ParkingLevel;
import java.time.LocalDateTime;



public class Ticket {
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private ParkingLevel parkingLevel;
    private final LocalDateTime entryTime;

    public Ticket(Vehicle vehicle, ParkingLevel parkingLevel, ParkingSpot parkingSpot){
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.parkingLevel = parkingLevel;
        this.entryTime = LocalDateTime.now();
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

    public ParkingSpot getParkingSpot(){
        return parkingSpot;
    }

    public ParkingLevel getParkingLevel(){
        return parkingLevel;
    }

    public LocalDateTime getEntryTime(){
        return entryTime;
    }
}
