package Ch;

/**
 * Passenger of a flight.
 * Knows how to print its own name, which the flight uses via delegation.
 */
public class Passenger {

    /** Name of the passenger. */
    private String name;

    /**
     * Creates a new passenger.
     *
     * @param name name of the passenger
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Prints the name of the passenger.
     */
    public void printName() {
        System.out.println(name);
    }

    /**
     * Returns the name.
     *
     * @return the name of the passenger
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }
}
