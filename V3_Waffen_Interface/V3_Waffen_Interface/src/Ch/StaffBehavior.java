package Ch;

/**
 * Weapon behavior with a magic staff.
 */
public class StaffBehavior implements WeaponBehavior {
    /**
     * Prints that a fireball is cast with the staff.
     */
    @Override
    public void useWeapon() {
        System.out.println("  casts a fireball with the magic staff.");
    }
}
