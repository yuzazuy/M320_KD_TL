package Ch;

/**
 * Passenger of a flight.
 * Abstract: every passenger books a concrete travel class, see {@link EconomyPassenger}
 * and {@link BusinessPassenger}. The subclasses decide the travel class and the
 * baggage allowance, so the flight can treat all passengers the same way (polymorphism).
 */
public abstract class Passenger {

    /** Name of the passenger. */
    private String name;

    /**
     * Creates a new passenger.
     *
     * @param name name of the passenger
     */
    protected Passenger(String name) {
        this.name = name;
    }

    /**
     * Returns the travel class of the passenger.
     *
     * @return the travel class, e.g. "Economy"
     */
    public abstract String getTravelClass();

    /**
     * Returns how many kilograms of baggage the passenger may check in.
     *
     * @return the baggage allowance in kilograms
     */
    public abstract int getBaggageAllowanceKg();

    /**
     * Prints the name, the travel class and the baggage allowance of the passenger.
     */
    public void printBoardingInfo() {
        System.out.println(name + " (" + getTravelClass() + ", "
                + getBaggageAllowanceKg() + " kg baggage)");
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
