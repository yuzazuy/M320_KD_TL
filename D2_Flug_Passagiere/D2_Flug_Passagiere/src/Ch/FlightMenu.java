package Ch;

import java.util.Scanner;

/**
 * Console menu of the D2 exercise.
 * Lets the user book or remove passengers and show the passenger list.
 */
public class FlightMenu {

    /** Reads the user input from the console. */
    private Scanner scanner = new Scanner(System.in);
    /** The flight the menu works with. */
    private Flight flight;

    /**
     * Creates the menu.
     *
     * @param flight the flight the menu works with
     */
    public FlightMenu(Flight flight) {
        this.flight = flight;
    }

    /**
     * Shows the menu again and again until the user chooses exit.
     */
    public void userMenu() {
        boolean running = true;

        while (running) {
            System.out.println("==============Menu=================");
            System.out.println("Flight " + flight.getFlightNumber());
            System.out.println("Press 1 to book yourself on the flight");
            System.out.println("Press 2 to remove a passenger");
            System.out.println("Press 3 to show the passenger list");
            System.out.println("Press 4 to exit");
            System.out.println("============Menu Done==============");

            // All invalid inputs are handled here in one place
            try {
                switch (scanner.nextLine().trim()) {
                    case "1" -> addPassenger();
                    case "2" -> removePassenger();
                    case "3" -> flight.printPassengerList();
                    case "4" -> {
                        System.out.println("Thank you and have a nice flight");
                        running = false;
                    }
                    default -> throw new FlightInputException("Invalid choice");
                }
            } catch (FlightInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Asks for a name and a travel class and books a new passenger with them.
     *
     * @throws FlightInputException if the name is empty or the travel class is invalid
     */
    private void addPassenger() throws FlightInputException {
        System.out.println("Enter your name:");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            throw new FlightInputException("Name must not be empty.");
        }

        System.out.println("Travel class? 1 = Economy, 2 = Business");
        Passenger passenger = createPassenger(scanner.nextLine().trim(), name);
        flight.addPassenger(passenger);
        System.out.println(name + " was booked in " + passenger.getTravelClass()
                + " on flight " + flight.getFlightNumber() + ".");
    }

    /**
     * Creates the passenger subclass that matches the chosen travel class.
     *
     * @param travelClass the menu choice, "1" for economy or "2" for business
     * @param name        name of the passenger
     * @return the new passenger
     * @throws FlightInputException if the travel class is not "1" or "2"
     */
    private Passenger createPassenger(String travelClass, String name) throws FlightInputException {
        return switch (travelClass) {
            case "1" -> new EconomyPassenger(name);
            case "2" -> new BusinessPassenger(name);
            default -> throw new FlightInputException("Invalid travel class, passenger not booked.");
        };
    }

    /**
     * Asks for a name and removes the passenger with this name.
     */
    private void removePassenger() {
        System.out.println("Enter the name of the passenger to remove:");
        String name = scanner.nextLine().trim();
        if (flight.removePassenger(name)) {
            System.out.println(name + " was removed from the flight.");
        } else {
            System.out.println("No passenger with the name " + name + " found.");
        }
    }
}
