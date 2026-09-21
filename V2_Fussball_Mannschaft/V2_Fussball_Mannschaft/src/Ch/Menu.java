package Ch;

public class Menu {

    //user input scanner thing
    void userMenu() {


        boolean startCondition = true;
        while (startCondition) {
            System.out.println("==============Menu=================");
            System.out.println("Pick one of the following options: ");
            System.out.println("Press 1 to list available teams with player names");
            System.out.println("Press 2 to create new players and add them to teams");
            System.out.println("Press 3 to create a new team");
            System.out.println("Press 4 to exit");

            int userChoice = 0;

            switch (userChoice) {
                case 1:
                    //team list teams and players, maybe enum necessary?
                    break;
                case 2:
                    //team creat players
                    break;
                case 3:
                    //still team, create new team
                    break;
                case 4:
                    System.out.println("Thank you and have a nice day");
                    startCondition = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }


    }



}
