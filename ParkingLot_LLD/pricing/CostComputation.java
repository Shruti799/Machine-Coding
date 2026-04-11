package ParkingLot_LLD.pricing;

import ParkingLot_LLD.Ticket;

public class CostComputation {
    PricingStrategy strategy;

    public CostComputation(PricingStrategy strategy){
        this.strategy = strategy;
    }

    public double computeCost(Ticket ticket){
        return strategy.CalculatePrice(ticket);
    }
}
