package Ch;

/**
 * Starts the Q3 exercise: loads the airports from the CSV file and opens the menu.
 */
public class MainQ3 {

    /** Default file, relative to the working directory (the Q3_HashMap project folder in IntelliJ). */
    public static final String DEFAULT_FILE = "airports.csv";

    /**
     * Entry point of the program.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        AirportMap map = new AirportMap();
        AirportMenu.load(DEFAULT_FILE, map);

        AirportMenu menu = new AirportMenu(map);
        menu.userMenu();
    }
}
