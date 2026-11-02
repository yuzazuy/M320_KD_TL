package Ch;

import java.util.ArrayList;

/**
 * Defender, a special form of player.
 * Overrides {@link #play()} to show the defender's role.
 */
public class Defender extends Team {

    /**
     * Creates a new defender.
     *
     * @param namePlayer name of the player
     * @param role       role of the player
     * @param team       name of the team
     * @param listTeam   list of all team names
     */
    public Defender(String namePlayer, String role, String team, ArrayList<String> listTeam) {
        super(namePlayer, role, team, listTeam);
    }

    /**
     * Prints the general text of {@link Team#play()} and then the defender's role.
     *
     * @return the role of the player
     */
    @Override
    String play() {
        super.play();
        System.out.println("  -> Defender: blocks the opposing strikers.");
        return role;
    }
}
