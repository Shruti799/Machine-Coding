package ParkingLot_LLD.Entity;
import ParkingLot_LLD.enums.VehicleType;

public class Vehicle {
    String vehicleNumber;
    VehicleType vehicleType;

    Vehicle(VechicleType vehicleType, String vehicleNumber){
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleNumber(){
        return vehicleNumber;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }
}
