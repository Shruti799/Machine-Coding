package ParkingLot_LLD.parkinglot;

import ParkingLot_LLD.Entity.Vehicle;
import ParkingLot_LLD.Ticket;
import ParkingLot_LLD.payment.Payment;



public class ParkingLot {
    private final ParkingBuilding parkingBuilding;
    private final EntranceGate entranceGate;
    private final ExitGate exitGate;

    public ParkingLot(ParkingBuilding parkingBuilding, EntranceGate entranceGate, ExitGate exitGate){
        this.parkingBuilding = parkingBuilding;
        this.entranceGate = entranceGate;
        this.exitGate = exitGate;
    }

    public Ticket vehicleArrives(Vehicle vehicle){
        return entranceGate.provideTicket(vehicle, parkingBuilding);
    }

    public void vehicleExits(Ticket ticket, Payment payment){
        exitGate.completeExit(parkingBuilding,ticket,payment);
    }
}
