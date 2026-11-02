package Ch;


/**
 * Starts the V2 exercise: creates a team with players and opens the menu.
 */
public class MainV2 {
    /**
     * Entry point of the program.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        // Team and players required by the task
        Team.listTeam.add("FC Zurich");
        Team.players.add(new Goalie("Yann", "Goalie", "FC Zurich", Team.listTeam));
        Team.players.add(new Defender("Manuel", "Defender", "FC Zurich", Team.listTeam));
        Team.players.add(new Striker("Breel", "Striker", "FC Zurich", Team.listTeam));


        Menu.userMenu();


    }

}
