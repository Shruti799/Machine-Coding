package Elevator_LLD;

import Elevator_LLD.enums.ElevatorDirection;

public class ElevatorCar {

    private final String id;
    public int currentFloor;
    public int nextStoppage;
    Door door;
    ElevatorDirection movingDirection;
   

    public ElevatorCar(String id){
        this.id = id;
        currentFloor = 0;
        door = new Door();
        movingDirection = ElevatorDirection.IDLE;
    }

    public void setCurrentFloor(int currentFloor){
        this.currentFloor = currentFloor;
    }

    public void showDisplay(){
        System.out.println("Current Floor: " + currentFloor + " " + "Direction: " + movingDirection);
    }

    public void moveElevatorCar(int destinationFloor){

        this.nextStoppage = destinationFloor;

        if(nextStoppage == currentFloor){
            showDisplay();
            door.openDoor(id);
            return;
        }

        int startFloor = currentFloor;
        door.closeDoor(id);

        if(nextStoppage > currentFloor){
            movingDirectionirection = ElevatorDirection.UP;
            showDisplay();
            for(int i=startFloor+1;i<=nextStoppage;i++){
                try {
                    Thread.sleep(6);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                setCurrentFloor(i);
                showDisplay();
            }
        }
        else{
            movingDirectionirection = ElevatorDirection.DOWN;
            showDisplay();
            for(int i=startFloor-1;i>=nextStoppage;i--){
                try {
                    Thread.sleep(6);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                setCurrentFloor(i);
                showDisplay();
            }
        }
        door.openDoor(id);
    }


}
