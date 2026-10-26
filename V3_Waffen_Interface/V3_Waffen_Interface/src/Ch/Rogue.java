package Ch;

/**
 * Rogue, a game character that starts with a dagger.
 */
public class Rogue extends GameCharacter {

    /**
     * Creates a new rogue with the default weapon of the Rogue (dagger).
     *
     * @param characterName name of the rogue
     */
    public Rogue(String characterName) {
        super(characterName, new DaggerBehavior());
    }
}
