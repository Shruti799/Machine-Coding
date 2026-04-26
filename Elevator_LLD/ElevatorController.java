package Elevator_LLD;

import java.util.concurrent.PriorityBlockingQueue;

import Elevator_LLD.enums.ElevatorDirection;

public class ElevatorController implements Runnable{

    private ElevatorCar elevatorCar;
    PriorityBlockingQueue<Integer> upMinQ;
    PriorityBlockingQueue<Integer> downMaxQ;

    private final Object monitor = new Object();

    public ElevatorController(ElevatorCar elevatorCar){
        this.elevatorCar = elevatorCar;
        upMinQ = new PriorityBlockingQueue<>();
        downMaxQ = new PriorityBlockingQueue<>(10, (a,b) -> b-a);
    }

    public void submitRequest(int destinationFloor){
        enqueue(destinationFloor);
    }

    private void enqueue(int destinationFloor){

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

        synchronized(monitor){
            // wake elevator thread
            monitor.notify();
        }

    }

    @Override
    void run(){
        controlElevator();
    }

    public void controlElevator(){
        while(true){
            // go to sleep as there is no request
            synchronized (monitor) {
                while(upMinQ.isEmpty() && downMaxQ.isEmpty()){
                    try {
                        System.out.println("Elevator: " + elevatorCar.id + "is IDLE");
                        elevatorCar.movingDirection = ElevatorDirection.IDLE;
                        monitor.wait();
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            while(!upMinQ.isEmpty()){
                int floor = upMinQ.poll();
                elevatorCar.moveElevatorCar(floor);
            }

            while(!downMaxQQ.isEmpty()){
                int floor = downMaxQ.poll();
                elevatorCar.moveElevatorCar(floor);
            }
        }
    }

}
