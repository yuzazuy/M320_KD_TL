package Ch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Flight with a list of passengers.
 * 1:n HAS-A relationship: one flight has many passengers.
 */
public class Flight {

    /** Number of the flight, e.g. "LX318". */
    private String flightNumber;
    /** All passengers booked on this flight. */
    private final List<Passenger> passengers = new ArrayList<>();

    /**
     * Creates a new flight without passengers.
     *
     * @param flightNumber number of the flight
     */
    public Flight(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * Books a passenger on the flight.
     *
     * @param passenger the passenger to add
     */
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    /**
     * Removes the first passenger with this name (upper/lower case is ignored).
     *
     * @param name name of the passenger to remove
     * @return true if a passenger was removed, false if none was found
     */
    public boolean removePassenger(String name) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equalsIgnoreCase(name)) {
                passengers.remove(passenger);
                // Return right away: going on with the loop after remove() would throw
                // a ConcurrentModificationException
                return true;
            }
        }
        return false;
    }

    /**
     * Prints all passengers of the flight and their total baggage allowance.
     * Delegation and polymorphism: each passenger prints its own boarding info,
     * in the way of its own travel class.
     */
    public void printPassengerList() {
        System.out.println("Passengers of flight " + flightNumber + ":");
        if (passengers.isEmpty()) {
            System.out.println("No passengers yet.");
            return;
        }
        for (Passenger passenger : passengers) {
            passenger.printBoardingInfo();
        }
        System.out.println("Total baggage allowance: " + getTotalBaggageAllowanceKg() + " kg");
    }

    /**
     * Adds up the baggage allowance of all passengers.
     * Each passenger returns the allowance of its own travel class.
     *
     * @return the total baggage allowance in kilograms
     */
    public int getTotalBaggageAllowanceKg() {
        int total = 0;
        for (Passenger passenger : passengers) {
            total += passenger.getBaggageAllowanceKg();
        }
        return total;
    }

    /**
     * Returns the flight number.
     *
     * @return the number of the flight
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Returns the passengers as a read-only list.
     * Passengers can only be added or removed through the flight.
     *
     * @return all passengers of the flight, cannot be changed
     */
    public List<Passenger> getPassengers() {
        return Collections.unmodifiableList(passengers);
    }
}
