package Elevator_LLD;

public class ElevatorController {

    private final String controllerId;
    private ElevatorCar car;

    public ElevatorController(String controllerId, ElevatorCar car){
        this.controllerId = controllerId;
        this.car = car;
    }

}
