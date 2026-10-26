package Ch;

import java.util.ArrayList;

/**
 * Goalie, a special form of player.
 * Overrides {@link #play()} to show the goalie's role.
 */
public class Goalie extends Team {


    /** Body size of the goalie in meters. */
    double bodySize;

    /**
     * Creates a new goalie.
     *
     * @param namePlayer name of the player
     * @param role       role of the player
     * @param team       name of the team
     * @param listTeam   list of all team names
     */
    public Goalie(String namePlayer, String role, String team, ArrayList<String> listTeam) {
        super(namePlayer, role, team, listTeam);
    }

    /**
     * Prints the name with "(Goalie)" after it.
     *
     * @return the name of the player
     */
    @Override
    public String showName() {
        System.out.println(namePlayer + " (Goalie)");
        return namePlayer;
    }

    /**
     * Prints the general text of {@link Team#play()} and then the goalie's role.
     *
     * @return the role of the player
     */
    @Override
    public String play() {
        super.play();
        System.out.println("  -> Goalie: guards the goal and catches the ball.");
        return role;
    }

    /**
     * Prints the team name, see {@link Team#teamName()}.
     *
     * @return the team name
     */
    @Override
    public String teamName() {
        return super.teamName();
    }

    /**
     * Creates a new team, see {@link Team#createNewTeam()}.
     *
     * @return the entered team name
     */
    //@Override
    public static String createNewTeam() {
        return Team.createNewTeam();
    }

    /**
     * Creates a new player, see {@link Team#createNewPlayer()}.
     *
     * @return the entered player name
     */
    //@Override
    public static String createNewPlayer() {

        return Team.createNewPlayer();
    }



}
