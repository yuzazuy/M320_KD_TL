package Ch;

/**
 * Thrown when the user enters invalid input in the menu.
 * The menu catches it, shows the message and then continues.
 */
public class AirportInputException extends Exception {

    /**
     * Creates the exception with a message for the user.
     *
     * @param message text that explains what was wrong
     */
    public AirportInputException(String message) {
        super(message);
    }
}
