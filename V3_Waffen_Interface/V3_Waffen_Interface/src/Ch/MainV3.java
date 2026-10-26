package Ch;

import java.util.ArrayList;

/**
 * Starts the V3 exercise: creates default characters and opens the menu.
 */
public class MainV3 {
    /**
     * Entry point of the program.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        // Default characters, more can be created in the menu
        ArrayList<GameCharacter> characters = new ArrayList<>();
        characters.add(new Warrior("Conan"));
        characters.add(new Mage("Gandalf"));
        characters.add(new Rogue("Garrett"));

        CharacterMenu menu = new CharacterMenu(characters);
        menu.userMenu();
    }
}
