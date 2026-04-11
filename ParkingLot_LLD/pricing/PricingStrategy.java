package ParkingLot_LLD.pricing;
import ParkingLot_LLD.Ticket;

public interface PricingStrategy {
    double CalculatePrice(Ticket ticket);
}
