package ParkingLot_LLD.parkinglot;
import ParkingLot_LLD.pricing.CostComputation;
import ParkingLot_LLD.payment.Payment;
import ParkingLot_LLD.Ticket;

public class ExitGate {

    private final CostComputation costComputation;

    public ExitGate(CostComputation costComputation){
        this.costComputation = costComputation;
    }

    public void completeExit(ParkingBuilding parkingBuilding, Ticket ticket, Payment payment){
        double amount = costComputation.computeCost(ticket);
        boolean paymentSuccess = payment.pay(amount);
        if(!paymentSuccess){
            throw new RuntimeException("Payment failed. Exit Denied!");
        }
        parkingBuilding.release(ticket);
        System.out.println("Payment Successful. Exit Gate opened!");
    }
}