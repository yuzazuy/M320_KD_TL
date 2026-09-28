package Ch;

import java.util.ArrayList;

public class Goalie extends Team {


    double bodySize;

    public Goalie(String namePlayer, String role, String team, ArrayList<String> listTeam) {
        super(namePlayer, role, team, listTeam);
    }

    @Override
    public String showName() {
        return "Goalie";
    }

    @Override
    public String play() {
        return "Goalie";
    }

    @Override
    public String teamName() {
        return teamName();
    }

    //@Override
    public static String createNewTeam() {
        return createNewTeam();
    }

    //@Override
    public static String createNewPlayer() {

        return createNewPlayer();
    }



}
