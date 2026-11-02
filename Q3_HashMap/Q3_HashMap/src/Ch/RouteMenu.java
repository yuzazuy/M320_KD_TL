package Ch;

import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * Console menu of the stack demo.
 * The user flies from airport to airport (push) and back again (pop), one step at a time.
 * The menu only knows the {@link SimpleStack} interface, so it works the same way
 * with an {@link ArrayStack} and a {@link LinkedStack} (polymorphism).
 */
public class RouteMenu {

    /** Airport codes of the example trip in flight order; ZRH is not in the file. */
    private static final String[] EXAMPLE_TRIP = {"JFK", "ORD", "ZRH", "DEN", "LAX"};

    /** Reads the user input from the console. */
    private final Scanner scanner = new Scanner(System.in);
    /** The airports from the CSV file, used to check codes and show names. */
    private final AirportMap map;
    /** The visited airport codes, the current airport is on top. */
    private SimpleStack<String> route;

    /**
     * Creates the menu.
     *
     * @param map the airports from the CSV file
     */
    public RouteMenu(AirportMap map) {
        this.map = map;
    }

    /**
     * Asks for the stack type and then shows the menu again and again until the user chooses exit.
     */
    public void userMenu() {
        route = chooseStack();
        boolean running = true;

        while (running) {
            System.out.println("==============Menu=================");
            System.out.println("Press 1 to fly to an airport (push)");
            System.out.println("Press 2 to fly the example trip " + String.join(", ", EXAMPLE_TRIP));
            System.out.println("Press 3 to show the current airport (peek)");
            System.out.println("Press 4 to fly back one airport (pop)");
            System.out.println("Press 5 to fly all the way home");
            System.out.println("Press 6 to exit");
            System.out.println("============Menu Done==============");

            // All invalid inputs are handled here in one place
            try {
                switch (scanner.nextLine().trim()) {
                    case "1" -> flyTo();
                    case "2" -> flyExampleTrip();
                    case "3" -> showCurrentAirport();
                    case "4" -> flyBackOne();
                    case "5" -> flyHome();
                    case "6" -> {
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
     * Asks which stack class stores the route, until the answer is valid.
     *
     * @return a new, empty stack of the chosen class
     */
    private SimpleStack<String> chooseStack() {
        SimpleStack<String> stack = null;
        while (stack == null) {
            System.out.println("Stack type? 1 = ArrayStack, 2 = LinkedStack");
            stack = switch (scanner.nextLine().trim()) {
                case "1" -> new ArrayStack<>();
                case "2" -> new LinkedStack<>();
                default -> {
                    System.out.println("Invalid choice, please enter 1 or 2.");
                    yield null;
                }
            };
        }
        System.out.println("The route uses the stack type " + stack.getClass().getSimpleName() + ".");
        return stack;
    }

    /**
     * Asks for an airport code and flies there.
     *
     * @throws AirportInputException if the code is not in the file
     */
    private void flyTo() throws AirportInputException {
        System.out.println("Enter the airport code to fly to (e.g. JFK):");
        String code = scanner.nextLine().trim().toUpperCase();
        if (!map.containsKey(code)) {
            throw new AirportInputException(code + " is not in the file, no flight.");
        }
        land(code);
    }

    /**
     * Flies every airport of the example trip that exists in the file.
     */
    private void flyExampleTrip() {
        for (String code : EXAMPLE_TRIP) {
            if (map.containsKey(code)) {
                land(code);
            } else {
                System.out.println(code + " is not in the file, skipped.");
            }
        }
    }

    /**
     * Puts the airport on top of the route and prints where the plane landed.
     *
     * @param code code of an airport that is in the file
     */
    private void land(String code) {
        route.push(code);
        System.out.println("Landed in " + code + " -> " + map.get(code)
                + " (stack size: " + route.size() + ")");
    }

    /**
     * Prints the airport on top of the route without removing it.
     */
    private void showCurrentAirport() {
        if (route.isEmpty()) {
            System.out.println("You are at home, no flight yet.");
            return;
        }
        String code = route.peek();
        System.out.println("Current airport (peek): " + code + " -> " + map.get(code)
                + " (stack size: " + route.size() + ")");
    }

    /**
     * Removes the airport on top of the route, so the plane flies back to the one before.
     */
    private void flyBackOne() {
        // pop() on an empty stack throws an exception, which here means the plane is home
        try {
            String code = route.pop();
            System.out.println("Leaving " + code + " -> " + map.get(code)
                    + " (stack size: " + route.size() + ")");
        } catch (EmptyStackException e) {
            System.out.println("The stack is empty, you are already home.");
            return;
        }
        if (route.isEmpty()) {
            System.out.println("You are back home.");
        }
    }

    /**
     * Flies back airport by airport in reverse order until the route is empty.
     */
    private void flyHome() {
        if (route.isEmpty()) {
            System.out.println("You are already home.");
        }
        while (!route.isEmpty()) {
            flyBackOne();
        }
    }
}
