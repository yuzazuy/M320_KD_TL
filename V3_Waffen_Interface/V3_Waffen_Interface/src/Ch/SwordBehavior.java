package Ch;

/**
 * Weapon behavior with a sword.
 */
public class SwordBehavior implements WeaponBehavior {

    /**
     * Creates the sword behavior.
     */
    public SwordBehavior() {
    }

    /**
     * Prints that a sword is swung.
     */
    @Override
    public void useWeapon() {
        System.out.println("  swings a heavy sword.");
    }
}
