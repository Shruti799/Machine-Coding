package ParkingLot_LLD;

import ParkingLot_LLD.LookupStrategy.ParkingSpotLookupStrategy;
import ParkingLot_LLD.LookupStrategy.RandomLookupStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ParkingLot_LLD.Entity.ParkingSpot;
import ParkingLot_LLD.Entity.Vehicle;
import ParkingLot_LLD.enums.VehicleType;
import ParkingLot_LLD.parkinglot.EntranceGate;
import ParkingLot_LLD.parkinglot.ExitGate;
import ParkingLot_LLD.parkinglot.ParkingBuilding;
import ParkingLot_LLD.parkinglot.ParkingLevel;
import ParkingLot_LLD.parkinglot.ParkingLot;
import ParkingLot_LLD.payment.CashPayment;
import ParkingLot_LLD.payment.UPIPayment;
import ParkingLot_LLD.pricing.CostComputation;
import ParkingLot_LLD.pricing.FixedPricingStrategy;
import ParkingLot_LLD.spotManagers.FourWheelerSpotManager;
import ParkingLot_LLD.spotManagers.ParkingSpotManager;
import ParkingLot_LLD.spotManagers.TwoWheelerSpotManager;

public class ParkingLotClient {
    public static void main(String[] args){
        ParkingSpotLookupStrategy strategy = new RandomLookupStrategy();
        Map<VehicleType, ParkingSpotManager> levelOneManagers = new HashMap<>();

        levelOneManagers.put(VehicleType.TWO_WHEELER, new TwoWheelerSpotManager(List.of(new ParkingSpot("L1-S1"),
                        new ParkingSpot("L1-S2")), strategy));

        levelOneManagers.put(VehicleType.FOUR_WHEELER,
                new FourWheelerSpotManager(List.of(new ParkingSpot("L1-S3")), strategy));

        ParkingLevel leve1 = new ParkingLevel(1,levelOneManagers);

        Map<VehicleType, ParkingSpotManager> levelTwoManagers = new HashMap<>();
        levelTwoManagers.put(VehicleType.TWO_WHEELER,
                new TwoWheelerSpotManager(List.of(new ParkingSpot("L2-S1")), strategy));

        levelTwoManagers.put(VehicleType.FOUR_WHEELER,
                new FourWheelerSpotManager(List.of(new ParkingSpot("L2-S2"),
                        new ParkingSpot("L2-S3")), strategy));


        ParkingLevel level2 = new ParkingLevel(2, levelTwoManagers);

        ParkingBuilding building = new ParkingBuilding(List.of(leve1,level2));

        ParkingLot parkingLot = new ParkingLot(
            building, 
            new EntranceGate(), 
            new ExitGate(new CostComputation(new FixedPricingStrategy()))
        );

        Vehicle bike = new Vehicle(VehicleType.TWO_WHEELER, "BIKE-101");
        Vehicle car = new Vehicle(VehicleType.FOUR_WHEELER, "CAR-201");


        Ticket t1 = parkingLot.vehicleArrives(bike);
        Ticket t2 = parkingLot.vehicleArrives(car);

        parkingLot.vehicleExits(t1, new CashPayment());
        parkingLot.vehicleExits(t2, new UPIPayment());



    }
}
