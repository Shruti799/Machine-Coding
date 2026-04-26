package Elevator_LLD;

import java.util.List;

import Elevator_LLD.enums.ElevatorDirection;

public class LeastBusyElevatorStrategy implements ElevatorSelectionStrategy{
    public ElevatorController selectElevator(List<ElevatorController> controllers, int floor, ElevatorDirection direction){

        ElevatorController leastBusyController = null;
        int minLoad = Integer.MAX_VALUE;

        for(ElevatorController controller : controllers){
            int load = controller.upMinQ.size() + controller.downMaxQ.size();
            if(load<minLoad){
                minLoad = load;
                leastBusyController = controller;
            }
        }

        return leastBusyController;
    }

}
