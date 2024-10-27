package org.example.elevator;

public class ElevatorDropRequest {
    // drop me at this floor. person calls this inside a lift.
    private Floor floor;

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
}
