package Ch;

import java.util.ArrayList;
import java.util.Scanner;

public class Team {

    public Team(String namePlayer, String role, String team, ArrayList<String> listTeam) {
        this.namePlayer = namePlayer;
        this.role = role;
        this.team = team;
        this.listTeam = listTeam;
    }


    String namePlayer = "";


    String showName() {
        System.out.println(this);
        return namePlayer;
    }

    //ArrayList for every generated or already available team

    String role = "";
    String play() {
        System.out.println(this);
        return role;
    };

    String team = "";
    String teamName() {
        System.out.println(this);
        return team;
    }


    static ArrayList<String> listTeam = new ArrayList<>();
    static String listTeamName() {
        for (String listTeam : listTeam) {
            System.out.println(listTeam);

        }
        return listTeam.get(0);
    }


    //these are more complicated
    static String createNewTeam() {

        ArrayList<String> newTeamList = new ArrayList<>();

        String input;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter team-members (type 'end' to stop):");
            while (!(input = scanner.nextLine()).equals("end")) {
                newTeamList.add(input);
                scanner.close();
            }
        }

        System.out.println("The ArrayList contains: " + newTeamList);

        //newTeamList.stream(member).forEach(member -> System.out.println(member));
        //System.out.println("The ArrayList contains: " + newTeamList);


        return newTeamList.get(newTeamList.size() - 1);
    };


    static String createNewPlayer() {
        ArrayList<String> newPlayerList = new ArrayList<>();
        String input;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter player name:");
            while (!(input = scanner.nextLine()).equals("end")) {
                newPlayerList.add(input);
                scanner.close();
            }
        }
        System.out.println("The ArrayList contains: " + newPlayerList);
        return input;
    };


    //how to add to arrayList?
    //as a for loop maybe, to fill it up according to index





    public String getNamePlayer() {
        return namePlayer;
    }

    public String getRole() {
        return role;
    }

    public String getTeam() {
        return team;
    }

    public ArrayList<String> getListTeam() {
        return listTeam;
    }


    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setListTeam(ArrayList<String> listTeam) {
        this.listTeam = listTeam;
    }
}
