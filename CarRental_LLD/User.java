package CarRental_LLD;

public class User {
    int userId;
    String userName;
    String drivingLicenseNo;

    public User(int userId, String userName, String drivingLicenseNo){
        this.userId = userId;
        this.userName = userName;
        this.drivingLicenseNo = drivingLicenseNo;
    }

    public int getUserId(){
        return userId;
    }

    public string getUserName(){
        return userName;
    }

    public getDrivingLicenseNo(){
        return drivingLicenseNo;
    }
}
