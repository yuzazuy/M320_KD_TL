package Ch;

import java.util.HashMap;

/**
 * Stores airports as key-value pairs.
 * Wraps a HashMap: key = airport code (e.g. "ZRH"), value = airport name.
 */
public class AirportMap {

    /** The HashMap with all airports: code -&gt; name. */
    private HashMap<String, String> airports = new HashMap<>();

    /**
     * Adds an airport. If the code already exists, the new name replaces the old one
     * (no duplicate keys).
     *
     * @param code airport code, used as key
     * @param name airport name, used as value
     * @return the old name, or null if the code was new
     */
    public String put(String code, String name) {
        return airports.put(code, name);
    }

    /**
     * Searches an airport by its code.
     *
     * @param code airport code to search
     * @return the airport name, or null if the code is not in the map
     */
    public String get(String code) {
        return airports.get(code);
    }

    /**
     * Checks if an airport code exists.
     *
     * @param code airport code to check
     * @return true if the code is in the map
     */
    public boolean containsKey(String code) {
        return airports.containsKey(code);
    }

    /**
     * Returns the number of airports.
     *
     * @return the number of entries in the map
     */
    public int size() {
        return airports.size();
    }

    /**
     * Removes all airports.
     */
    public void clear() {
        airports.clear();
    }

    /**
     * Prints all airports.
     * A HashMap has no fixed order, so the entries can appear in any order.
     */
    public void printAll() {
        if (airports.isEmpty()) {
            System.out.println("No airports yet.");
        }
        for (String code : airports.keySet()) {
            System.out.println(code + " -> " + airports.get(code));
        }
    }
}
