package Ch;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Superclass of all players (Goalie, Defender, Striker).
 * Also manages the static lists of all teams and all players.
 * The subclasses override {@link #play()} to show their role during the game.
 */
public class Team {

    /** One scanner for the whole program, System.in must never be closed. */
    static Scanner scanner = new Scanner(System.in);

    /** All created players (Goalie, Defender, Striker) in one list thanks to polymorphism. */
    static ArrayList<Team> players = new ArrayList<>();

    /**
     * Creates a new player.
     *
     * @param namePlayer name of the player
     * @param role       role of the player (e.g. "Goalie")
     * @param team       name of the team the player belongs to
     * @param listTeam   list of all team names
     */
    public Team(String namePlayer, String role, String team, ArrayList<String> listTeam) {
        this.namePlayer = namePlayer;
        this.role = role;
        this.team = team;
        this.listTeam = listTeam;
    }


    /** Name of the player. */
    String namePlayer = "";


    /**
     * Prints the name of the player.
     *
     * @return the name of the player
     */
    String showName() {
        System.out.println(namePlayer);
        return namePlayer;
    }

    //ArrayList for every generated or already available team

    /** Role of the player (e.g. "Goalie"). */
    String role = "";
    /**
     * Prints what the player does during the game.
     * Subclasses extend this with their role.
     *
     * @return the role of the player
     */
    String play() {
        System.out.println(namePlayer + " (team " + team + ") runs onto the pitch.");
        return role;
    };

    /** Name of the team the player belongs to. */
    String team = "";
    /**
     * Prints the team name of the player.
     *
     * @return the team name
     */
    String teamName() {
        System.out.println(team);
        return team;
    }


    /** Names of all teams. */
    static ArrayList<String> listTeam = new ArrayList<>();
    /**
     * Prints every team with the names of its players.
     *
     * @return the first team name, or an empty text if there are no teams
     */
    static String listTeamName() {
        if (listTeam.isEmpty()) {
            System.out.println("No teams yet.");
            return "";
        }
        for (String listTeam : listTeam) {
            System.out.println("Team " + listTeam + ":");
            // Only the players of this team are shown
            for (Team player : players) {
                if (player.team.equals(listTeam)) {
                    player.showName();
                }
            }
        }
        return listTeam.get(0);
    }

    /**
     * Lets all players play.
     * Each player calls its own overridden {@link #play()} (polymorphism).
     */
    static void playAll() {
        if (players.isEmpty()) {
            System.out.println("No players yet.");
        }
        for (Team player : players) {
            player.play();
        }
    }


    //these are more complicated
    /**
     * Asks the user for a team name and adds it to the team list if it is new.
     *
     * @return the entered team name
     */
    static String createNewTeam() {

        System.out.println("Enter team name:");
        String input = scanner.nextLine();
        // No duplicate team names
        if (!listTeam.contains(input)) {
            listTeam.add(input);
        }

        System.out.println("The ArrayList contains: " + listTeam);



        return input;
    };


    /**
     * Asks the user for name, team and role and creates the matching player.
     * The player and a new team are only saved if the role is valid.
     *
     * @return the entered player name
     */
    static String createNewPlayer() {
        System.out.println("Enter player name:");
        String input = scanner.nextLine();

        System.out.println("Enter team name:");
        String teamName = scanner.nextLine();

        System.out.println("Role? 1 = Goalie, 2 = Defender, 3 = Striker");
        String role = scanner.nextLine();

        // The role decides which subclass is created
        Team player;
        if (role.equals("1")) {
            player = new Goalie(input, "Goalie", teamName, listTeam);
        } else if (role.equals("2")) {
            player = new Defender(input, "Defender", teamName, listTeam);
        } else if (role.equals("3")) {
            player = new Striker(input, "Striker", teamName, listTeam);
        } else {
            System.out.println("Invalid role, player not created.");
            return input;
        }

        // Team is only saved when the player is valid
        if (!listTeam.contains(teamName)) {
            listTeam.add(teamName);
        }
        players.add(player);
        System.out.println(input + " was added to team " + teamName + ".");
        return input;
    };


    //how to add to arrayList?
    //as a for loop maybe, to fill it up according to index





    /**
     * Returns the player name.
     *
     * @return the name of the player
     */
    public String getNamePlayer() {
        return namePlayer;
    }

    /**
     * Returns the role.
     *
     * @return the role of the player
     */
    public String getRole() {
        return role;
    }

    /**
     * Returns the team name.
     *
     * @return the team of the player
     */
    public String getTeam() {
        return team;
    }

    /**
     * Returns the list of all team names.
     *
     * @return all team names
     */
    public ArrayList<String> getListTeam() {
        return listTeam;
    }


    /**
     * Sets the player name.
     *
     * @param namePlayer the new name
     */
    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    /**
     * Sets the role.
     *
     * @param role the new role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Sets the team name.
     *
     * @param team the new team
     */
    public void setTeam(String team) {
        this.team = team;
    }

    /**
     * Sets the list of all team names.
     *
     * @param listTeam the new list of team names
     */
    public void setListTeam(ArrayList<String> listTeam) {
        this.listTeam = listTeam;
    }
}
