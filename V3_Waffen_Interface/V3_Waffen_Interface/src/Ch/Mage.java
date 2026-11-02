package Ch;

/**
 * Mage, a game character that starts with a magic staff.
 */
public class Mage extends GameCharacter {

    /**
     * Creates a new mage with the default weapon of the Mage (staff).
     *
     * @param characterName name of the mage
     */
    public Mage(String characterName) {
        super(characterName, new StaffBehavior());
    }
}
