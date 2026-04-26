package Elevator_LLD;

import java.util.List;

import Elevator_LLD.enums.ElevatorDirection;

public class NearestElevatorStrategy implements ElevatorSelectionStrategy{

    public ElevatorController selectElevator(List<ElevatorController> controllers, int floor, ElevatorDirection direction){
        ElevatorController nearestController = null;
        int minDistance = Integer.MAX_VALUE;

        for(ElevatorController controller : controllers){

            if(controller.elevatorCar.movingDirection == direction){

                if((direction==ElevatorDirection.UP && controller.elevatorCar.nextStoppage <= floor) ||
                (direction==ElevatorDirection.DOWN && controller.elevatorCar.nextStoppage >= floor)){

                    int distance = Math.abs(controller.elevatorCar.nextStoppage - floor);

                    if(distance<minDistance){
                        minDistance = distance;
                        nearestController = controller;
                    }
                }
            }
        }

        if(nearestController == null){
            for(ElevatorController controller : controllers){
                if(controller.ElevatorCar.movingDirection == ElevatorDirection.IDLE){
                    nearestController = controller;
                    break;
                }
            }
            if(nearestController == null){
                nearestController = controllers.get(0);
            }
        }

        return nearestController;
    }
}
