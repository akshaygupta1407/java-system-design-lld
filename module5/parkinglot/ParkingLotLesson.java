package module5.parkinglot;

import java.util.ArrayList;
import java.util.List;

enum VehicleType {
    BIKE,
    CAR,
    TRUCK
}

abstract class Vehicle {
    private final String licensePlate;
    private final VehicleType type;

    protected Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }
}

class Bike extends Vehicle {
    public Bike(String licensePlate) {
        super(licensePlate, VehicleType.BIKE);
    }
}

class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }
}

class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate, VehicleType.TRUCK);
    }
}

abstract class ParkingSpot {
    private final String spotId;
    private final VehicleType supportedType;
    private Vehicle parkedVehicle;

    protected ParkingSpot(String spotId, VehicleType supportedType) {
        this.spotId = spotId;
        this.supportedType = supportedType;
    }

    public boolean canFit(Vehicle vehicle) {
        return parkedVehicle == null && supportedType == vehicle.getType();
    }

    public void park(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
    }

    public void vacate() {
        this.parkedVehicle = null;
    }

    public String getSpotId() {
        return spotId;
    }
}

class BikeSpot extends ParkingSpot {
    public BikeSpot(String spotId) {
        super(spotId, VehicleType.BIKE);
    }
}

class CarSpot extends ParkingSpot {
    public CarSpot(String spotId) {
        super(spotId, VehicleType.CAR);
    }
}

class TruckSpot extends ParkingSpot {
    public TruckSpot(String spotId) {
        super(spotId, VehicleType.TRUCK);
    }
}

class Ticket {
    private final String ticketId;
    private final String licensePlate;
    private final String spotId;

    public Ticket(String ticketId, String licensePlate, String spotId) {
        this.ticketId = ticketId;
        this.licensePlate = licensePlate;
        this.spotId = spotId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getSpotId() {
        return spotId;
    }
}

class ParkingLot {
    private final List<ParkingSpot> spots = new ArrayList<>();

    public ParkingLot() {
        spots.add(new BikeSpot("B1"));
        spots.add(new CarSpot("C1"));
        spots.add(new TruckSpot("T1"));
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.canFit(vehicle)) {
                spot.park(vehicle);
                return new Ticket("TICKET-" + vehicle.getLicensePlate(), vehicle.getLicensePlate(), spot.getSpotId());
            }
        }
        throw new IllegalStateException("No parking spot available for " + vehicle.getType());
    }
}

public class ParkingLotLesson {
    public static void main(String[] args) {
        System.out.println("--- Parking Lot Demo ---");

        ParkingLot parkingLot = new ParkingLot();
        Ticket carTicket = parkingLot.parkVehicle(new Car("KA-01-1234"));
        Ticket bikeTicket = parkingLot.parkVehicle(new Bike("KA-01-BIKE"));

        System.out.println("Car parked with ticket: " + carTicket.getTicketId() + ", spot: " + carTicket.getSpotId());
        System.out.println("Bike parked with ticket: " + bikeTicket.getTicketId() + ", spot: " + bikeTicket.getSpotId());
    }
}
