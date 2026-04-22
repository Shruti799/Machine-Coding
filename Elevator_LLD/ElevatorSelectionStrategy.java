package Elevator_LLD;

import Elevator_LLD.enums.ElevatorDirection;

public interface ElevatorSelectionStrategy {
    ElevatorController selectElevator(List<ElevatorController> controllers, int floor, ElevatorDirection direction);
}
