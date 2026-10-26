package Ch;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Console menu of the Q3 exercise.
 * Lets the user search airports by code, show all, add airports and load a file.
 */
public class AirportMenu {

    /** Reads the user input from the console. */
    private Scanner scanner = new Scanner(System.in);
    /** The map the menu works with. */
    private AirportMap map;

    /**
     * Creates the menu.
     *
     * @param map the map the menu works with
     */
    public AirportMenu(AirportMap map) {
        this.map = map;
    }

    /**
     * Shows the menu again and again until the user chooses exit.
     */
    public void userMenu() {
        boolean running = true;

        while (running) {
            System.out.println("==============Menu=================");
            System.out.println("Press 1 to search an airport by code");
            System.out.println("Press 2 to show all airports");
            System.out.println("Press 3 to add or replace an airport");
            System.out.println("Press 4 to load a file");
            System.out.println("Press 5 to exit");
            System.out.println("============Menu Done==============");

            // All invalid inputs are handled here in one place
            try {
                switch (scanner.nextLine().trim()) {
                    case "1" -> search();
                    case "2" -> map.printAll();
                    case "3" -> addAirport();
                    case "4" -> loadFile();
                    case "5" -> {
                        System.out.println("Thank you and have a nice day");
                        running = false;
                    }
                    default -> throw new AirportInputException("Invalid choice");
                }
            } catch (AirportInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Asks for an airport code and prints the matching airport name.
     */
    private void search() {
        System.out.println("Enter an airport code (e.g. JFK):");
        // Codes are stored in upper case, so "jfk" also finds "JFK"
        String code = scanner.nextLine().trim().toUpperCase();

        // get() returns null if the code is not in the map
        String name = map.get(code);
        if (name == null) {
            System.out.println("No airport found for " + code + ".");
        } else {
            System.out.println(code + " -> " + name);
        }
    }

    /**
     * Asks for code and name and adds the airport, or replaces the name if the code exists.
     *
     * @throws AirportInputException if the code or the name is invalid
     */
    private void addAirport() throws AirportInputException {
        System.out.println("Enter the airport code (3 letters):");
        String code = scanner.nextLine().trim().toUpperCase();
        // Check the code right away, before asking for the name
        if (code.length() != 3) {
            throw new AirportInputException("The code must have exactly 3 letters.");
        }

        System.out.println("Enter the airport name:");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            throw new AirportInputException("Name must not be empty.");
        }

        String oldName = map.put(code, name);
        if (oldName == null) {
            System.out.println(code + " was added.");
        } else {
            System.out.println(code + " already existed, \"" + oldName + "\" was replaced.");
        }
    }

    /**
     * Asks for a file name and loads it. Pressing Enter loads the default file.
     */
    private void loadFile() {
        System.out.println("Enter the file name (press Enter for " + MainQ3.DEFAULT_FILE + "):");
        String fileName = scanner.nextLine().trim();
        if (fileName.isEmpty()) {
            fileName = MainQ3.DEFAULT_FILE;
        }
        load(fileName, map);
    }

    /**
     * Loads a file into the map and prints the result.
     * Used by the menu and by {@link MainQ3} at the start.
     *
     * @param fileName path of the CSV file
     * @param map      the map the airports are put into
     */
    public static void load(String fileName, AirportMap map) {
        try {
            AirportFileReader.readFile(fileName, map);
            System.out.println("File loaded, the map now has " + map.size() + " airports.");
        } catch (IOException e) {
            // Shows the full path, so the user sees where the program looked for the file
            System.out.println("Could not read file: " + Path.of(fileName).toAbsolutePath());
        }
    }
}
