package org.example.elevator;

public class ElevatorCallRequest {
    // request elevator from the floor
    private Floor floor;
    // to go UP or DOWN
    private Direction direction;

    public Floor getFloor() {
        return floor;
    }

    public Direction getDirection() {
        return direction;
    }
}
