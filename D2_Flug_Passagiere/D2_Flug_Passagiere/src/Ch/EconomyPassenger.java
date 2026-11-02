package Ch;

/**
 * Passenger who travels in economy class.
 */
public class EconomyPassenger extends Passenger {

    /** Baggage allowance of the economy class in kilograms. */
    private static final int BAGGAGE_ALLOWANCE_KG = 23;

    /**
     * Creates a new economy passenger.
     *
     * @param name name of the passenger
     */
    public EconomyPassenger(String name) {
        super(name);
    }

    /**
     * Returns the travel class.
     *
     * @return "Economy"
     */
    @Override
    public String getTravelClass() {
        return "Economy";
    }

    /**
     * Returns the baggage allowance of the economy class.
     *
     * @return the baggage allowance in kilograms
     */
    @Override
    public int getBaggageAllowanceKg() {
        return BAGGAGE_ALLOWANCE_KG;
    }
}
