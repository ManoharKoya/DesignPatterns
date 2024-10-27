package org.example.elevator;

import java.util.List;
import java.util.Set;

public class ElevatorSystem {
    private List<Elevator> elevators;
    private Set<ElevatorCallRequest> elevatorCallRequests;
    private List<Floor> floors;

    public void start(int floorCount, int elevatorCount) throws Exception {
        if(floorCount<=1) {
            throw new Exception("Can't create an Elevator system with less than one floor.");
        }
        if(elevatorCount<=1) {
            throw new Exception("Can't create an Elevator system with less than one elevator.");
        }
        for(int floorNumber=0; floorNumber<floorCount; floorNumber++) {
            floors.add(new Floor(floorNumber));
        }
        for(int elevatorNumber=0; elevatorNumber<elevatorCount; elevatorNumber++) {
            elevators.add(new Elevator(floors.get(0), floorCount));
        }
    }

    public void newRequest(ElevatorCallRequest elevatorCallRequest) throws Exception {
        int floorNumber = elevatorCallRequest.getFloor().getFloorNumber();
        if(floorNumber > floors.size() || floorNumber < 0)
            throw new Exception("Request can't be from a non existing floor");
        elevatorCallRequests.add(elevatorCallRequest);
        schedule();
    }

    public void schedule() {
        // check if already some lift is already going to that floor & serving request direction is same as
        for(ElevatorCallRequest request: elevatorCallRequests) {
            for(Elevator elevator: elevators) {
                if(elevator.getState() == State.MOVING &&
                        elevator.getCallDestinationFloor() == request.getFloor() &&
                        elevator.getRequestDirection() == request.getDirection()) {
                    // already this lift is serving the same purpose.
                    elevatorCallRequests.remove(request);
                    return;
                }
            }
            // assign any idle lift to this purpose. & remove the request from set.
            for(Elevator elevator: elevators) {
                if(elevator.getState() == State.IDLE) {
                    elevator.assignToRequest(request);
                    elevatorCallRequests.remove(request);
                }
            }
        }
    }


    // Lot more things to add, check all comments.
    // -- try to figure out a design pattern to include. (None included as of now).

}
