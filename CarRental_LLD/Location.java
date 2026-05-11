package CarRental_LLD;

public class Location {
    String country;
    String state;
    String city;
    String area;
    int pincode;
    int buildingNo;

    public Location(String country, String state, String city, String area, int pincode, int buildingNo){
        this.country = country;
        this.state = state;
        this.city = city;
        this.area = area;
        this.pincode = pincode;
        this.buildingNo = buildingNo;
    }

    public String getState(){
        return state;
    }

    public String getCity(){
        return city;
    }

    public String getArea(){
        return area;
    }

    public int getPincode(){
        return pincode;
    }

    public int getBuildingNo(){
        return buildingNo;
    }
}
