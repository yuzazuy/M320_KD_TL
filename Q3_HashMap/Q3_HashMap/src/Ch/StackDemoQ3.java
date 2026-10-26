package Ch;

import java.util.EmptyStackException;

/**
 * Shows how {@link SimpleStack} works with the airports from the CSV file.
 * A trip is flown airport by airport (push), the way back goes in reverse order (pop).
 */
public class StackDemoQ3 {

    /**
     * Entry point of the demo.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        AirportMap map = new AirportMap();
        AirportMenu.load(MainQ3.DEFAULT_FILE, map);

        // The stack stores airport codes, so T is String
        SimpleStack<String> route = new SimpleStack<>();
        String[] trip = {"JFK", "ORD", "ZRH", "DEN", "LAX"};

        System.out.println("=== Outbound trip (push) ===");
        for (String code : trip) {
            // Only airports from the CSV file are added
            if (map.containsKey(code)) {
                route.push(code);
                System.out.println("Landed in " + code + " -> " + map.get(code)
                        + " (stack size: " + route.size() + ")");
            } else {
                System.out.println(code + " is not in the file, skipped.");
            }
        }

        // peek() shows the top element without removing it
        if (!route.isEmpty()) {
            System.out.println("Current airport (peek): " + route.peek());
        }

        System.out.println("=== Way back (pop, last in first out) ===");
        while (!route.isEmpty()) {
            String code = route.pop();
            System.out.println("Leaving " + code + " -> " + map.get(code)
                    + " (stack size: " + route.size() + ")");
        }

        // pop() on an empty stack throws an exception
        try {
            route.pop();
        } catch (EmptyStackException e) {
            System.out.println("The stack is empty, you are back home.");
        }
    }
}
