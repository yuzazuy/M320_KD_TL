package Ch;

import java.util.EmptyStackException;

/**
 * Shows how a {@link SimpleStack} works with the airports from the CSV file.
 * A trip is flown airport by airport (push), the way back goes in reverse order (pop).
 * The same trip runs once with an {@link ArrayStack} and once with a {@link LinkedStack}:
 * the demo only uses the interface, so both give the same result (polymorphism).
 */
public class StackDemoQ3 {

    /**
     * Not used: the class only holds static methods.
     */
    private StackDemoQ3() {
    }

    /** Airport codes of the trip in flight order. */
    private static final String[] TRIP = {"JFK", "ORD", "ZRH", "DEN", "LAX"};

    /**
     * Entry point of the demo.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        AirportMap map = new AirportMap();
        AirportMenu.loadDefault(map);

        flyRoundTrip(new ArrayStack<>(), map);
        flyRoundTrip(new LinkedStack<>(), map);
    }

    /**
     * Flies the trip out and back with the given stack.
     *
     * @param route the empty stack that stores the visited airport codes
     * @param map   the airports from the CSV file
     */
    private static void flyRoundTrip(SimpleStack<String> route, AirportMap map) {
        System.out.println();
        System.out.println("##### Stack type: " + route.getClass().getSimpleName() + " #####");
        flyOutbound(route, map);
        flyBack(route, map);
    }

    /**
     * Pushes every airport of the trip that exists in the file and shows the current airport.
     *
     * @param route the stack that stores the visited airport codes
     * @param map   the airports from the CSV file
     */
    private static void flyOutbound(SimpleStack<String> route, AirportMap map) {
        System.out.println("=== Outbound trip (push) ===");
        for (String code : TRIP) {
            if (map.containsKey(code)) {
                route.push(code);
                System.out.println("Landed in " + code + " -> " + map.get(code)
                        + " (stack size: " + route.size() + ")");
            } else {
                System.out.println(code + " is not in the file, skipped.");
            }
        }
        if (!route.isEmpty()) {
            System.out.println("Current airport (peek): " + route.peek());
        }
    }

    /**
     * Pops all airports in reverse order until the stack is empty.
     *
     * @param route the stack that stores the visited airport codes
     * @param map   the airports from the CSV file
     */
    private static void flyBack(SimpleStack<String> route, AirportMap map) {
        System.out.println("=== Way back (pop, last in first out) ===");
        while (!route.isEmpty()) {
            String code = route.pop();
            System.out.println("Leaving " + code + " -> " + map.get(code)
                    + " (stack size: " + route.size() + ")");
        }

        // One more pop() on the empty stack shows the exception
        try {
            route.pop();
        } catch (EmptyStackException e) {
            System.out.println("The stack is empty, you are back home.");
        }
    }
}
