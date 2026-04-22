package module5.parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PRACTICE SOLUTION: Parking Lot System
 *
 * This version supports:
 * 1. Multiple floors
 * 2. Entry and exit flow
 * 3. Ticket generation
 * 4. Pricing calculation
 *
 * The design is intentionally simple so it is easy to study and extend.
 */

enum VehicleTypePractice {
    BIKE,
    CAR,
    TRUCK
}

abstract class VehiclePractice {
    private final String licensePlate;
    private final VehicleTypePractice type;

    protected VehiclePractice(String licensePlate, VehicleTypePractice type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleTypePractice getType() {
        return type;
    }
}

class BikePractice extends VehiclePractice {
    public BikePractice(String licensePlate) {
        super(licensePlate, VehicleTypePractice.BIKE);
    }
}

class CarPractice extends VehiclePractice {
    public CarPractice(String licensePlate) {
        super(licensePlate, VehicleTypePractice.CAR);
    }
}

class TruckPractice extends VehiclePractice {
    public TruckPractice(String licensePlate) {
        super(licensePlate, VehicleTypePractice.TRUCK);
    }
}

abstract class ParkingSpotPractice {
    private final String spotId;
    private final VehicleTypePractice supportedType;
    private VehiclePractice parkedVehicle;

    protected ParkingSpotPractice(String spotId, VehicleTypePractice supportedType) {
        this.spotId = spotId;
        this.supportedType = supportedType;
    }

    public boolean canPark(VehiclePractice vehicle) {
        return parkedVehicle == null && supportedType == vehicle.getType();
    }

    public void park(VehiclePractice vehicle) {
        this.parkedVehicle = vehicle;
    }

    public void vacate() {
        this.parkedVehicle = null;
    }

    public String getSpotId() {
        return spotId;
    }
}

class BikeSpotPractice extends ParkingSpotPractice {
    public BikeSpotPractice(String spotId) {
        super(spotId, VehicleTypePractice.BIKE);
    }
}

class CarSpotPractice extends ParkingSpotPractice {
    public CarSpotPractice(String spotId) {
        super(spotId, VehicleTypePractice.CAR);
    }
}

class TruckSpotPractice extends ParkingSpotPractice {
    public TruckSpotPractice(String spotId) {
        super(spotId, VehicleTypePractice.TRUCK);
    }
}

class ParkingFloorPractice {
    private final String floorId;
    private final List<ParkingSpotPractice> spots = new ArrayList<>();

    public ParkingFloorPractice(String floorId) {
        this.floorId = floorId;
    }

    public void addSpot(ParkingSpotPractice spot) {
        spots.add(spot);
    }

    public String getFloorId() {
        return floorId;
    }

    public ParkingSpotPractice findSpot(VehiclePractice vehicle) {
        for (ParkingSpotPractice spot : spots) {
            if (spot.canPark(vehicle)) {
                return spot;
            }
        }
        return null;
    }
}

class TicketPractice {
    private final String ticketId;
    private final String licensePlate;
    private final String floorId;
    private final String spotId;
    private final LocalDateTime entryTime;

    public TicketPractice(String ticketId, String licensePlate, String floorId, String spotId, LocalDateTime entryTime) {
        this.ticketId = ticketId;
        this.licensePlate = licensePlate;
        this.floorId = floorId;
        this.spotId = spotId;
        this.entryTime = entryTime;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getFloorId() {
        return floorId;
    }

    public String getSpotId() {
        return spotId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}

interface PricingStrategyPractice {
    double calculateFee(VehicleTypePractice vehicleType, Duration duration);
}

class SimplePricingStrategy implements PricingStrategyPractice {
    @Override
    public double calculateFee(VehicleTypePractice vehicleType, Duration duration) {
        long hours = Math.max(1, duration.toHours());
        double ratePerHour;

        switch (vehicleType) {
            case BIKE:
                ratePerHour = 20.0;
                break;
            case CAR:
                ratePerHour = 50.0;
                break;
            case TRUCK:
                ratePerHour = 80.0;
                break;
            default:
                ratePerHour = 50.0;
        }

        return hours * ratePerHour;
    }
}

class ParkingLotPracticeSystem {
    private final List<ParkingFloorPractice> floors = new ArrayList<>();
    private final Map<String, TicketPractice> activeTickets = new HashMap<>();
    private final PricingStrategyPractice pricingStrategy;

    public ParkingLotPracticeSystem(PricingStrategyPractice pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void addFloor(ParkingFloorPractice floor) {
        floors.add(floor);
    }

    public TicketPractice enter(VehiclePractice vehicle) {
        for (ParkingFloorPractice floor : floors) {
            ParkingSpotPractice spot = floor.findSpot(vehicle);
            if (spot != null) {
                spot.park(vehicle);
                TicketPractice ticket = new TicketPractice(
                        "TICKET-" + vehicle.getLicensePlate(),
                        vehicle.getLicensePlate(),
                        floor.getFloorId(),
                        spot.getSpotId(),
                        LocalDateTime.now()
                );
                activeTickets.put(ticket.getTicketId(), ticket);
                System.out.println("Vehicle " + vehicle.getLicensePlate() + " parked at " + floor.getFloorId() + " - " + spot.getSpotId());
                return ticket;
            }
        }
        throw new IllegalStateException("No available spot for " + vehicle.getType());
    }

    public double exit(String ticketId, VehiclePractice vehicle, LocalDateTime exitTime) {
        TicketPractice ticket = activeTickets.remove(ticketId);
        if (ticket == null) {
            throw new IllegalArgumentException("Invalid ticket: " + ticketId);
        }

        Duration duration = Duration.between(ticket.getEntryTime(), exitTime);
        double fee = pricingStrategy.calculateFee(vehicle.getType(), duration);
        System.out.println("Vehicle " + vehicle.getLicensePlate() + " exited from " + ticket.getFloorId() + " - " + ticket.getSpotId());
        System.out.println("Parking fee: Rs. " + fee);
        return fee;
    }
}

public class ParkingLotPractice {
    public static void main(String[] args) {
        System.out.println("--- Parking Lot Practice ---");

        ParkingFloorPractice floor1 = new ParkingFloorPractice("F1");
        floor1.addSpot(new BikeSpotPractice("B1"));
        floor1.addSpot(new CarSpotPractice("C1"));

        ParkingFloorPractice floor2 = new ParkingFloorPractice("F2");
        floor2.addSpot(new TruckSpotPractice("T1"));
        floor2.addSpot(new CarSpotPractice("C2"));

        ParkingLotPracticeSystem parkingLot = new ParkingLotPracticeSystem(new SimplePricingStrategy());
        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        VehiclePractice car = new CarPractice("KA-01-1234");
        VehiclePractice bike = new BikePractice("KA-01-BIKE");
        VehiclePractice truck = new TruckPractice("KA-01-TRUCK");

        TicketPractice carTicket = parkingLot.enter(car);
        TicketPractice bikeTicket = parkingLot.enter(bike);
        TicketPractice truckTicket = parkingLot.enter(truck);

        parkingLot.exit(carTicket.getTicketId(), car, carTicket.getEntryTime().plusHours(2));
        parkingLot.exit(bikeTicket.getTicketId(), bike, bikeTicket.getEntryTime().plusHours(1));
        parkingLot.exit(truckTicket.getTicketId(), truck, truckTicket.getEntryTime().plusHours(3));

        System.out.println("Parking lot practice completed.");
    }
}
