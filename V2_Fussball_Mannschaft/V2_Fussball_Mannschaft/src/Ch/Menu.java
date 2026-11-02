package Ch;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Console menu of the V2 exercise.
 * Lets the user list teams, create players and teams, and let all players play.
 */
public class Menu extends Team {

    /**
     * Creates a menu object (not needed to start the menu, {@link #userMenu()} is static).
     *
     * @param namePlayer name of the player
     * @param role       role of the player
     * @param team       name of the team
     * @param listTeam   list of all team names
     */
    public Menu(String namePlayer, String role, String team, ArrayList<String> listTeam) {
        super(namePlayer, role, team, listTeam);
    }


    /**
     * Shows the menu again and again until the user chooses exit.
     */
    public static void userMenu() {


        boolean flag = true;

        while (flag) {


            System.out.println("==============Menu=================");
            System.out.println("Pick one of the following options: ");
            System.out.println("Press 1 to list available teams with player names");
            System.out.println("Press 2 to create new players and add them to teams");
            System.out.println("Press 3 to create a new team");
            System.out.println("Press 4 to play (all players show their role)");
            System.out.println("Press 5 to exit");
            System.out.println("============Menu Done==============");

            try {
                int userChoice = scanner.nextInt();
                scanner.nextLine(); // removes the Enter after the number

                switch (userChoice) {
                    case 1:
                        listTeamName();
                        break;
                    case 2:
                        createNewPlayer();
                        break;
                    case 3:
                        createNewTeam();
                        break;
                    case 4:
                        playAll();
                        break;
                    case 5:
                        System.out.println("Thank you and have a nice day");
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid choice");

                }
            } catch (InputMismatchException e) {
                // The input was not a number: show a message and remove the wrong input
                System.out.println("Invalid input!");
                scanner.nextLine();

            }

        }

    }
}
