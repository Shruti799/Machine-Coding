package ParkingLot_LLD.payment;

public class CashPayment implements Payment{
    public boolean pay(double amount){
        System.out.println("Cash payment of" + amount + " Successfull");
        return true;
    }
}
