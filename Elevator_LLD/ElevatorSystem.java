package Elevator_LLD;
import java.util.Arrays;

import Elevator_LLD.enums;

public class ElevatorSystem {
    public static void main(String[] args){
        try {
            // Creating elevator cars and their controllers
            ElevatorCar car1 = new ElevatorCar(1);
            ElevatorController controller1 = new ElevatorController(car1);

            ElevatorCar car2 = new ElevatorCar(2);
            ElevatorController controller2 = new ElevatorController(car2);


            // Creating one internal buttons for each elevator
            InternalButton internalButton_for_elevator1 = new InternalButton(controller1);
            InternalButton internalButton_for_elevator2 = new InternalButton(controller2);


            // Creating Scheduler with Nearest Strategy
            ElevatorScheduler elevatorScheduler = new ElevatorScheduler(
                    Arrays.asList(controller1, controller2),
                    new NearestElevatorStrategy()
            );

            //Creating External Dispatcher
            ExternalDispatcher externalDispatcher = new ExternalDispatcher(elevatorScheduler);

            // Creating a 5 floor building:
            Building building = new Building(5, externalDispatcher);

            //Starting both the elevator controllers threads
            new Thread(controller1, "Elevator-1").start();
            new Thread(controller2, "Elevator-2").start();

            building.getFloor(3).pressUpButton();
            Thread.sleep(5);

            building.getFloor(5).pressDownButton();
            Thread.sleep(5);

            internalButton_for_elevator1.pressButton(4); // user inside elevator 1 presses floor 4
            Thread.sleep(5);

            internalButton_for_elevator1.pressButton(5); // user inside elevator 1 presses floor 5
            Thread.sleep(5);

            building.getFloor(1).pressDownButton();
            Thread.sleep(5);

            building.getFloor(2).pressUpButton();
            Thread.sleep(5);

            internalButton_for_elevator1.pressButton(2); // user inside elevator1 presses floor 2
        }
        catch (Exception e) {

        }

    }
}
