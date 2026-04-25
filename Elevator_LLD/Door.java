package Elevator_LLD;
import Elevator_LLD.enums.DoorState;

public class Door {
    private DoorState doorState;

    public Door(){
        doorState = doorState.DOOR_CLOSED;
    }

    public void openDoor(int id){
        doorState = doorState.DOOR_OPEN;
        System.out.println("Door is open for elevator: " + id);
    }

    public void closeDoor(int id){
        doorState = doorState.DOOR_CLOSED;
        System.out.println("Door is closed for elevator: " + id);
    }

}
