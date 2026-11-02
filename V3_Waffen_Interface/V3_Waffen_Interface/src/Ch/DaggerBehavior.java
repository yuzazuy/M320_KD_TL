package Ch;

/**
 * Weapon behavior with a dagger.
 */
public class DaggerBehavior implements WeaponBehavior {

    /**
     * Creates the dagger behavior.
     */
    public DaggerBehavior() {
    }

    /**
     * Prints that someone stabs with a dagger.
     */
    @Override
    public void useWeapon() {
        System.out.println("  stabs quickly with a dagger.");
    }
}
