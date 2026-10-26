package Ch;

import java.util.ArrayList;

/**
 * Flight with a list of passengers.
 * 1:n HAS-A relationship: one flight has many passengers.
 */
public class Flight {

    /** Number of the flight, e.g. "LX318". */
    private String flightNumber;
    /** All passengers booked on this flight. */
    private ArrayList<Passenger> passengers = new ArrayList<>();

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
                // Return right away: the list must not be used further after removing
                return true;
            }
        }
        return false;
    }

    /**
     * Prints all passengers of the flight.
     * Delegation: each passenger prints its own name.
     */
    public void printPassengerList() {
        System.out.println("Passengers of flight " + flightNumber + ":");
        if (passengers.isEmpty()) {
            System.out.println("No passengers yet.");
        }
        for (Passenger passenger : passengers) {
            passenger.printName();
        }
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
     * Returns the list of passengers.
     *
     * @return all passengers of the flight
     */
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }
}
