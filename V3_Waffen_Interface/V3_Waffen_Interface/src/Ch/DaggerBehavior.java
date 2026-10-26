package Ch;

/**
 * Weapon behavior with a dagger.
 */
public class DaggerBehavior implements WeaponBehavior {
    /**
     * Prints that someone stabs with a dagger.
     */
    @Override
    public void useWeapon() {
        System.out.println("  stabs quickly with a dagger.");
    }
}
