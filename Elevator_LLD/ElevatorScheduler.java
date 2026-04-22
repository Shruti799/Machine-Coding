package Elevator_LLD;
import java.util.List;

import Elevator_LLD.enums.ElevatorDirection;

public class ElevatorScheduler {

    private final List<ElevatorController> controllers;
    private ElevatorSelectionStrategy strategy;

    public ElevatorScheduler(List<ElevatorController> controllers, ElevatorSelectionStrategy strategy){
        this.controllers = controllers;
        this.strategy = strategy;
    }

    public ElevatorController findElevatorController(int floor, ElevatorDirection direction){
        return strategy.selectElevator(controllers, floor, direction);
    }

}
