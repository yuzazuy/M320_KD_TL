package Ch;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Console menu of the V3 exercise.
 * Lets the user create characters, list them, let them fight and change their weapon.
 */
public class CharacterMenu {

    /** Reads the user input from the console. */
    private Scanner scanner = new Scanner(System.in);
    /** All characters of the game. */
    private ArrayList<GameCharacter> characters;

    /**
     * Creates the menu.
     *
     * @param characters the list of characters the menu works with
     */
    public CharacterMenu(ArrayList<GameCharacter> characters) {
        this.characters = characters;
    }

    /**
     * Shows the menu again and again until the user chooses exit.
     */
    public void userMenu() {
        boolean running = true;

        while (running) {
            System.out.println("==============Menu=================");
            System.out.println("Press 1 to create a new character");
            System.out.println("Press 2 to list all characters");
            System.out.println("Press 3 to let all characters walk and fight");
            System.out.println("Press 4 to change the weapon of a character");
            System.out.println("Press 5 to exit");
            System.out.println("============Menu Done==============");

            // All invalid inputs are handled here in one place
            try {
                switch (scanner.nextLine().trim()) {
                    case "1" -> createCharacter();
                    case "2" -> listCharacters();
                    case "3" -> fightAll();
                    case "4" -> changeWeapon();
                    case "5" -> {
                        System.out.println("Thank you and have a nice day");
                        running = false;
                    }
                    default -> throw new CharacterInputException("Invalid choice");
                }
            } catch (CharacterInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Asks for type and name and creates the matching character.
     * Each input is checked right after it is entered.
     *
     * @throws CharacterInputException if the type or the name is invalid
     */
    private void createCharacter() throws CharacterInputException {
        System.out.println("Type? 1 = Warrior, 2 = Mage, 3 = Rogue");
        String type = scanner.nextLine().trim();
        // Check the type right away, before asking for the name
        if (!type.equals("1") && !type.equals("2") && !type.equals("3")) {
            throw new CharacterInputException("Invalid type, character not created.");
        }

        System.out.println("Enter character name:");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            throw new CharacterInputException("Name must not be empty.");
        }

        // The type decides which subclass is created
        switch (type) {
            case "1" -> characters.add(new Warrior(name));
            case "2" -> characters.add(new Mage(name));
            case "3" -> characters.add(new Rogue(name));
        }
        System.out.println(name + " was created.");
    }

    /**
     * Prints all characters with a number, name and type.
     */
    private void listCharacters() {
        if (characters.isEmpty()) {
            System.out.println("No characters yet.");
        }
        // The number shown is the index + 1, so it starts at 1
        for (int i = 0; i < characters.size(); i++) {
            GameCharacter character = characters.get(i);
            System.out.println((i + 1) + ": " + character.getCharacterName()
                    + " (" + character.getClass().getSimpleName() + ")");
        }
    }

    /**
     * Lets every character walk and fight with its current weapon.
     */
    private void fightAll() {
        if (characters.isEmpty()) {
            System.out.println("No characters yet.");
        }
        for (GameCharacter character : characters) {
            character.walk();
            character.fight();
        }
    }

    /**
     * Gives a chosen character a new weapon.
     * Shows the advantage of the interface: the weapon changes without a new class.
     *
     * @throws CharacterInputException if the number or the weapon is invalid
     */
    private void changeWeapon() throws CharacterInputException {
        listCharacters();
        if (characters.isEmpty()) {
            return;
        }

        System.out.println("Enter the number of the character:");
        int index;
        // parseInt throws an exception if the input is not a number
        try {
            index = Integer.parseInt(scanner.nextLine().trim()) - 1;
        } catch (NumberFormatException e) {
            throw new CharacterInputException("Invalid number.");
        }
        if (index < 0 || index >= characters.size()) {
            throw new CharacterInputException("Invalid number.");
        }

        System.out.println("New weapon? 1 = Sword, 2 = Staff, 3 = Dagger");
        GameCharacter character = characters.get(index);
        switch (scanner.nextLine().trim()) {
            case "1" -> character.setWeaponBehavior(new SwordBehavior());
            case "2" -> character.setWeaponBehavior(new StaffBehavior());
            case "3" -> character.setWeaponBehavior(new DaggerBehavior());
            default -> throw new CharacterInputException("Invalid weapon, nothing changed.");
        }
        System.out.println(character.getCharacterName() + " has a new weapon:");
        character.fight();
    }
}
