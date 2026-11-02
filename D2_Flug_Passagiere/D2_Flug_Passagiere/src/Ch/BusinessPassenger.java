package Ch;

/**
 * Passenger who travels in business class.
 * Gets more baggage and priority boarding.
 */
public class BusinessPassenger extends Passenger {

    /** Baggage allowance of the business class in kilograms. */
    private static final int BAGGAGE_ALLOWANCE_KG = 32;

    /**
     * Creates a new business passenger.
     *
     * @param name name of the passenger
     */
    public BusinessPassenger(String name) {
        super(name);
    }

    /**
     * Returns the travel class.
     *
     * @return "Business"
     */
    @Override
    public String getTravelClass() {
        return "Business";
    }

    /**
     * Returns the baggage allowance of the business class.
     *
     * @return the baggage allowance in kilograms
     */
    @Override
    public int getBaggageAllowanceKg() {
        return BAGGAGE_ALLOWANCE_KG;
    }

    /**
     * Prints the general boarding info and adds the priority boarding.
     */
    @Override
    public void printBoardingInfo() {
        super.printBoardingInfo();
        System.out.println("  -> priority boarding");
    }
}
