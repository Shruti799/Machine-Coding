package Elevator_LLD;

import java.util.concurrent.PriorityBlockingQueue;

public class ElevatorController {

    private ElevatorCar elevatorCar;
    PriorityBlockingQueue<Integer> upMinQ;
    PriorityBlockingQueue<Integer> downMaxQ;

    public ElevatorController(ElevatorCar elevatorCar){
        this.elevatorCar = elevatorCar;
        upMinQ = new PriorityBlockingQueue<>();
        downMaxQ = new PriorityBlockingQueue<>(10, (a,b) -> b-a);
    }

    public void submitRequest(int destinationFloor){
        enqueue(destinationFloor);
    }

    public void enqueue(int destinationFloor){

        int nextStop = elevatorCar.nextStoppage;

        if(destinationFloor == nextStop){
            return;
        }

        else if(destinationFloor > nextStop){
           if(!upMinQ.contains(destinationFloor)){
             upMinQ.offer(destinationFloor);
           }
        }

        else{
            if(!downMaxQ.contains(destinationFloor)){
              downMaxQ.offer(destinationFloor);
            }
        }
    }




}
