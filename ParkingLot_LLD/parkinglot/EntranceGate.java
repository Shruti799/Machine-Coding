package ParkingLot_LLD.parkinglot;

import ParkingLot_LLD.Entity.Vehicle;
import ParkingLot_LLD.Ticket;

public class EntranceGate {
    public Ticket provideTicket(Vehicle vehicle, ParkingBuilding parkingBuilding){
        return parkingBuilding.allocateTicket(vehicle);
    }
}
