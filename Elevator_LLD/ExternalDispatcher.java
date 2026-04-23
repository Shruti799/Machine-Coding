package Elevator_LLD;

import Elevator_LLD.enums.ElevatorDirection;

public class ExternalDispatcher {
    private ElevatorScheduler scheduler;

    public ExternalDispatcher(ElevatorScheduler scheduler){
        this.scheduler = scheduler;
    }

    public void submitExternalRequest(int currentFloor, ElevatorDirection direction){
        ElevatorController controller = scheduler.findElevatorController(currentFloor,direction);
        controller.moveElevatorCar(currentFloor);
    }
}
