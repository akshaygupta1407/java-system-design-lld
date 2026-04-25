package module6.elevator;

import java.util.ArrayList;
import java.util.List;

/**
 * PRACTICE SOLUTION: Elevator System
 *
 * This version supports:
 * 1. Multiple elevators
 * 2. Floor requests
 * 3. Direction/state tracking
 * 4. A simple scheduling strategy
 */

enum ElevatorDirectionPractice {
    UP,
    DOWN,
    IDLE
}

class ElevatorRequestPractice {
    private final int floor;
    private final ElevatorDirectionPractice direction;

    public ElevatorRequestPractice(int floor, ElevatorDirectionPractice direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public int getFloor() {
        return floor;
    }

    public ElevatorDirectionPractice getDirection() {
        return direction;
    }
}

class ElevatorCarPractice {
    private final String elevatorId;
    private int currentFloor;
    private ElevatorDirectionPractice direction;

    public ElevatorCarPractice(String elevatorId) {
        this.elevatorId = elevatorId;
        this.currentFloor = 0;
        this.direction = ElevatorDirectionPractice.IDLE;
    }

    public String getElevatorId() {
        return elevatorId;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public ElevatorDirectionPractice getDirection() {
        return direction;
    }

    public void moveTo(int targetFloor) {
        if (targetFloor > currentFloor) {
            direction = ElevatorDirectionPractice.UP;
        } else if (targetFloor < currentFloor) {
            direction = ElevatorDirectionPractice.DOWN;
        } else {
            direction = ElevatorDirectionPractice.IDLE;
        }

        System.out.println(elevatorId + " moving from floor " + currentFloor + " to " + targetFloor + " (" + direction + ")");
        currentFloor = targetFloor;
        direction = ElevatorDirectionPractice.IDLE;
    }
}

class ElevatorControllerPractice {
    private final List<ElevatorCarPractice> elevators = new ArrayList<>();
    private final List<ElevatorRequestPractice> requests = new ArrayList<>();

    public void addElevator(ElevatorCarPractice elevator) {
        elevators.add(elevator);
    }

    public void addRequest(ElevatorRequestPractice request) {
        requests.add(request);
    }

    public void processRequests() {
        for (ElevatorRequestPractice request : requests) {
            ElevatorCarPractice chosen = chooseElevator(request);
            System.out.println("Assigning floor " + request.getFloor() + " request to " + chosen.getElevatorId());
            chosen.moveTo(request.getFloor());
        }
        requests.clear();
    }

    private ElevatorCarPractice chooseElevator(ElevatorRequestPractice request) {
        ElevatorCarPractice best = elevators.get(0);
        int bestDistance = Math.abs(best.getCurrentFloor() - request.getFloor());

        for (ElevatorCarPractice elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - request.getFloor());
            if (distance < bestDistance) {
                best = elevator;
                bestDistance = distance;
            }
        }

        return best;
    }
}

public class ElevatorPractice {
    public static void main(String[] args) {
        System.out.println("--- Elevator Practice ---");

        ElevatorControllerPractice controller = new ElevatorControllerPractice();
        controller.addElevator(new ElevatorCarPractice("E1"));
        controller.addElevator(new ElevatorCarPractice("E2"));

        controller.addRequest(new ElevatorRequestPractice(5, ElevatorDirectionPractice.UP));
        controller.addRequest(new ElevatorRequestPractice(2, ElevatorDirectionPractice.DOWN));
        controller.addRequest(new ElevatorRequestPractice(9, ElevatorDirectionPractice.UP));

        controller.processRequests();

        System.out.println("Elevator practice completed.");
    }
}
