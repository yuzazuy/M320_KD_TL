package Ch;

/**
 * Starts the D2 exercise: creates a flight and opens the menu.
 */
public class MainD2 {
    /**
     * Entry point of the program.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        Flight flight = new Flight("LX318");
        FlightMenu menu = new FlightMenu(flight);
        menu.userMenu();
    }
}
