package Ch;

/**
 * Thrown when the user enters invalid input in the menu.
 * The menu catches it, shows the message and then continues.
 */
public class CharacterInputException extends Exception {

    /** Version of the class for serialization, required because Exception is serializable. */
    private static final long serialVersionUID = 1L;

    /**
     * Creates the exception with a message for the user.
     *
     * @param message text that explains what was wrong
     */
    public CharacterInputException(String message) {
        super(message);
    }
}
