package Elevator_LLD;
import Elevator_LLD.enums.DoorState;

public class Door {
    private DoorState doorState;

    public Door(){
        doorState = doorState.DOOR_CLOSED;
    }

    public void openDoor(){
        doorState = doorState.DOOR_OPEN;
    }

    public void closeDoor(){
        doorState = doorState.DOOR_CLOSED;
    }

}
