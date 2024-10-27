package org.example.elevator;

import java.util.Iterator;
import java.util.Set;

public class Elevator {

    private State state;
    private Floor presentFloor, callDestinationFloor;
    private int topFloor;
    // assuming this set is sorted increasing order based on the moving direction.
    private Set<ElevatorDropRequest> dropRequests;



    public State getState() {
        return state;
    }

    public Floor getCallDestinationFloor() {
        return callDestinationFloor;
    }

    private Direction movingDirection, requestDirection;

    public Direction getRequestDirection() {
        return requestDirection;
    }
    public Elevator(Floor presentFloor, int topFloor) {
        this.presentFloor = presentFloor;
        this.state = State.IDLE;
        this.topFloor = topFloor;
    }
    public void assignToRequest(ElevatorCallRequest request) {
        this.callDestinationFloor = request.getFloor();
        this.requestDirection = request.getDirection();
        // change the state, moving direction
        this.state = State.MOVING;
        this.movingDirection = (this.callDestinationFloor.getFloorNumber() > this.presentFloor.getFloorNumber()) ? Direction.UP : Direction.DOWN;
    }

    public void move() throws Exception {
        if(this.state == State.IDLE) return;
        if(this.callDestinationFloor != null) {
            while (this.callDestinationFloor.getFloorNumber() != this.presentFloor.getFloorNumber()) {
                moveElevator();
            }
        }
        if(this.dropRequests.size() != 0) {
            // get the first dropRequest (sorted decreasing - farther one first)
            ElevatorDropRequest fartherDropRequest = null;
            for(ElevatorDropRequest request: dropRequests) {
                fartherDropRequest = request;
                break;
            }
            while(fartherDropRequest.getFloor().getFloorNumber() != this.presentFloor.getFloorNumber()) {
                moveElevator();
            }
        }
    }
    private void moveElevator() throws Exception {
        int floorNumber = this.presentFloor.getFloorNumber();
        if (floorNumber + 1 < topFloor && floorNumber >= 0) {
            if (this.movingDirection == Direction.UP) {
                this.presentFloor.setFloorNumber(floorNumber + 1);
            } else {
                this.presentFloor.setFloorNumber(floorNumber - 1);
            }
            // also need to check if there is a STOP in this floor. --> if so, STOP & remove the DropRequest from elevatorDropRequests.
        } else {
            throw new Exception("Invalid destination floor");
        }
    }
}
