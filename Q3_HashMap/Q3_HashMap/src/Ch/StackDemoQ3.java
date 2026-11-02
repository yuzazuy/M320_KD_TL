package Ch;

/**
 * Starts the stack demo: loads the airports from the CSV file and opens the {@link RouteMenu}.
 * In the menu the user flies a route airport by airport (push) and back in reverse order (pop).
 */
public class StackDemoQ3 {

    /**
     * Not used: the class only holds the static {@code main} method.
     */
    private StackDemoQ3() {
    }

    /**
     * Entry point of the demo.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        AirportMap map = new AirportMap();
        AirportMenu.loadDefault(map);

        RouteMenu menu = new RouteMenu(map);
        menu.userMenu();
    }
}
