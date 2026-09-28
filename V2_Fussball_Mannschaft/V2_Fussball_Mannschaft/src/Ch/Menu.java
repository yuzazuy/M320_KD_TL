package Ch;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu extends Team {

    public Menu(String namePlayer, String role, String team, ArrayList<String> listTeam) {
        super(namePlayer, role, team, listTeam);
    }


    public static void userMenu() {


        boolean flag = true;

        while (flag) {


            System.out.println("==============Menu=================");
            System.out.println("Pick one of the following options: ");
            System.out.println("Press 1 to list available teams with player names");
            System.out.println("Press 2 to create new players and add them to teams");
            System.out.println("Press 3 to create a new team");
            System.out.println("Press 4 to exit");
            System.out.println("============Menu Done==============");

            Scanner sc = null;
            try {
                sc = new Scanner(System.in);
                int userChoice;
                userChoice = sc.nextInt();

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
                        System.out.println("Thank you and have a nice day");
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid choice");

                }
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe!");
                sc.nextLine();

            }

        }

    }
}
