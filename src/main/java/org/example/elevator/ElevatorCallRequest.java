package org.example.elevator;

public class ElevatorCallRequest {
    // request elevator from the floor
    private Floor floor;
    // to go UP or DOWN
    private Direction direction;

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
