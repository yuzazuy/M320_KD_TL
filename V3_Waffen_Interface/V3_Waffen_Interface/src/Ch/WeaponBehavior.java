package Ch;

/**
 * Weapon behavior that is moved out of the character hierarchy into this interface.
 * Every weapon class implements it in its own way, so a character can use any weapon.
 */
public interface WeaponBehavior {
    /**
     * Uses the weapon and prints what happens.
     */
    void useWeapon();
}
