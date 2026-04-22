package Elevator_LLD;
import java.util.List;
import java.util.ArrayListList;


public class Building {

    List<FLoor> floors = new ArrayList<>();

    public Building(int totalFloors, ExternalDispatcher dispatcher){
        for(int i=1;i<=totalFloors;i++){
            floors.add(new Floor(i,dispatcher));
        }
    }

    public FLoor getFloor(int floorNumber){
        return floors.get(floorNumber-1);
    }
}
