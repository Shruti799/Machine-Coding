package ParkingLot_LLD.pricing;
import ParkingLot_LLD.Ticket;

public class FixedPricingStrategy implements PricingStrategy{
    public double CalculatePrice(Ticket ticket){
        return 100;
    }
}
