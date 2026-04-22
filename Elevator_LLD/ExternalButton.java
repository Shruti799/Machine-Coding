package Elevator_LLD;

import Elevator_LLD.enums.ElevatorDirection;

public class ExternalButton {

    private ExternalDispatcher dispatcher;

    public ExternalButton(ExternalDispatcher dispatcher){
        this.dispatcher = dispatcher;
    }

    public void pressButton(int floor, ElevatorDirection direction){
        dispatcher.submitExternalRequest(floor,direction);
    }
}
