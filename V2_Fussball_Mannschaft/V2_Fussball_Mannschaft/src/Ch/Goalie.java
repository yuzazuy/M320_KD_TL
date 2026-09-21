package Ch;

public class Goalie implements Team {


    double bodySize;

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
        return Team.super.teamName();
    }

    @Override
    public String createNewTeam() {
        return Team.super.createNewTeam();
    }

    @Override
    public String createNewPlayer() {

        return Team.super.createNewPlayer();
    }



}
