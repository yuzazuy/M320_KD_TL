package Ch;

/**
 * Warrior, a game character that starts with a sword.
 */
public class Warrior extends GameCharacter {

    /**
     * Creates a new warrior with the default weapon of the Warrior (sword).
     *
     * @param characterName name of the warrior
     */
    public Warrior(String characterName) {
        super(characterName, new SwordBehavior());
    }
}
