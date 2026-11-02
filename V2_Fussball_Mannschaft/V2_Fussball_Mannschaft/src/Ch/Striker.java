package Ch;

import java.util.ArrayList;

/**
 * Striker, a special form of player.
 * Overrides {@link #play()} to show the striker's role.
 */
public class Striker extends Team {
    /**
     * Creates a new striker.
     *
     * @param namePlayer name of the player
     * @param role       role of the player
     * @param team       name of the team
     * @param listTeam   list of all team names
     */
    public Striker(String namePlayer, String role, String team, ArrayList<String> listTeam) {
        super(namePlayer, role, team, listTeam);
    }

    /**
     * Prints that the striker does a jog training.
     *
     * @return the name of the player
     */
    String jogTraining() {
        System.out.println(namePlayer + " jogs around the pitch to stay fit.");
        return namePlayer;
    }

    /**
     * Prints the general text of {@link Team#play()} and then the striker's role.
     *
     * @return the role of the player
     */
    @Override
    String play() {
        super.play();
        System.out.println("  -> Striker: shoots at the goal.");
        return role;
    }

}
