package ParkingLot_LLD.payment;

public class UPIPayment implements Payment{
    public boolean pay(double amount){
        System.out.println("UPI Payment of" + amount + " Successfull.");
        return true;
    }
}
