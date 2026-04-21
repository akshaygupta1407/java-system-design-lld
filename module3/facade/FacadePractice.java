package module3.facade;

/**
 * PRACTICE QUESTION: Facade Pattern
 *
 * Scenario: You are building a travel booking system.
 *
 * Your goal:
 * 1. Create subsystem classes for:
 *    - Flight booking
 *    - Hotel booking
 *    - Cab booking
 * 2. Create a `TravelFacade` that gives one simple method to book a full trip.
 * 3. The client should call only the facade, not each subsystem directly.
 *
 * Hint:
 * The facade should coordinate the booking flow for the user.
 */

class FlightBooking {
    public void book() {
        System.out.println("Booking Flight");
    }
}

class HotelBooking {
    public void book() {
        System.out.println("Booking Hotel");
    }
}

class CabBooking {
    public void book() {
        System.out.println("Booking Cab");
    }
}

class TravelFacade {
    private final FlightBooking flightBooking = new FlightBooking();
    private final HotelBooking hotelBooking = new HotelBooking();
    private final CabBooking cabBooking = new CabBooking();

    public void bookTrip() {
        flightBooking.book();
        hotelBooking.book();
        cabBooking.book();
    }
}

public class FacadePractice {
    public static void main(String[] args) {
        System.out.println("--- Facade Practice ---");

        TravelFacade travelFacade = new TravelFacade();
        travelFacade.bookTrip();

        System.out.println("Complete the TODOs to practice Facade.");
    }
}
