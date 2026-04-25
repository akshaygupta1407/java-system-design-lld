package module6.elevator;

import java.util.ArrayList;
import java.util.List;

enum Direction {
    UP,
    DOWN,
    IDLE
}

class ElevatorRequest {
    private final int floor;
    private final Direction direction;

    public ElevatorRequest(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public int getFloor() {
        return floor;
    }

    public Direction getDirection() {
        return direction;
    }
}

class Elevator {
    private int currentFloor = 0;
    private Direction direction = Direction.IDLE;

    public void moveTo(int floor) {
        if (floor > currentFloor) {
            direction = Direction.UP;
        } else if (floor < currentFloor) {
            direction = Direction.DOWN;
        } else {
            direction = Direction.IDLE;
        }

        System.out.println("Moving from floor " + currentFloor + " to " + floor + " (" + direction + ")");
        currentFloor = floor;
        direction = Direction.IDLE;
    }
}

class ElevatorController {
    private final Elevator elevator = new Elevator();
    private final List<ElevatorRequest> requests = new ArrayList<>();

    public void addRequest(ElevatorRequest request) {
        requests.add(request);
    }

    public void processRequests() {
        for (ElevatorRequest request : requests) {
            elevator.moveTo(request.getFloor());
        }
        requests.clear();
    }
}

public class ElevatorLesson {
    public static void main(String[] args) {
        System.out.println("--- Elevator Demo ---");
        ElevatorController controller = new ElevatorController();
        controller.addRequest(new ElevatorRequest(3, Direction.UP));
        controller.addRequest(new ElevatorRequest(7, Direction.UP));
        controller.addRequest(new ElevatorRequest(2, Direction.DOWN));
        controller.processRequests();
    }
}
