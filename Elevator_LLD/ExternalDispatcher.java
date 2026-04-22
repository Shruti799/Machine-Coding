package Elevator_LLD;

import Elevator_LLD.enums.ElevatorDirection;

public class ExternalDispatcher {
    private ElevatorScheduler scheduler;

    public ExternalDispatcher(ElevatorScheduler scheduler){
        this.scheduler = scheduler;
    }

    public void submitExternalRequest(int floor, ElevatorDirection direction){
        ElevatorController controller = scheduler.findElevatorController(floor,direction);
        controller.sendElevatorCar(floor);
    }
}
