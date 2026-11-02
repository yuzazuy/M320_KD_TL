package Ch;

/**
 * Base class of all game characters.
 * Called GameCharacter because "Character" already exists in java.lang.
 * The character HAS a {@link WeaponBehavior} (aggregation) instead of overriding the fight method.
 */
public class GameCharacter {

    /** Name of the character. */
    private String characterName;
    /** HAS-A relationship (aggregation): the character has a weapon behavior. */
    private WeaponBehavior weaponBehavior;

    /**
     * Creates a new character.
     *
     * @param characterName  name of the character
     * @param weaponBehavior weapon the character uses
     */
    public GameCharacter(String characterName, WeaponBehavior weaponBehavior) {
        this.characterName = characterName;
        this.weaponBehavior = weaponBehavior;
    }

    /**
     * Prints that the character walks.
     */
    public void walk() {
        System.out.println(characterName + " walks across the battlefield.");
    }

    /**
     * Lets the character fight with its current weapon.
     * No more overriding needed: the fight is delegated to the weapon behavior.
     */
    public void fight() {
        System.out.println(characterName + " (" + getClass().getSimpleName() + ") fights:");
        weaponBehavior.useWeapon();
    }

    /**
     * Returns the name.
     *
     * @return the name of the character
     */
    public String getCharacterName() {
        return characterName;
    }

    /**
     * Sets the name.
     *
     * @param characterName the new name
     */
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    /**
     * Changes the weapon, also while the program runs.
     *
     * @param weaponBehavior the new weapon
     */
    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }
}
