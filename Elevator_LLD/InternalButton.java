package Elevator_LLD;

public class InternalButton {

    private ElevatorController controller;

    public InternalButton(ElevatorController controller){
        this.controller = controller;
    }

    public void pressButton(int destinationFloor){
        InternalDispatcher.getInstance().submitInternalRequest(destinationFloor,controller);
    }
}
