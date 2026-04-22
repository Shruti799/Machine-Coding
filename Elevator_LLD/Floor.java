package Elevator_LLD;

import Elevator_LLD.enums.ElevatorDirection;

public class Floor {
    int floorNumber;
    ExternalButton upButton;
    ExternalButton downButton;

    public Floor(int floorNumber, ExternalDispatcher dispatcher){
        this.floorNumber = floorNumber;
        this.upButton = new ExternalButton(dispatcher);
        this.downButton = new ExternalButton(dispatcher);
    }

    public void pressUpButton(){
        upButton.pressButton(floorNumber, ElevatorDirection.UP);
    }

    public void pressDownButton(){
        downButton.pressButton(floorNumber, ElevatorDirection.DOWN);
    }

    public int getFloorNumber(){
        return floorNumber;
    }
}
