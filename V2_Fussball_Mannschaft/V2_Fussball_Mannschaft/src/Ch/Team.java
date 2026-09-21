package Ch;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public interface Team {




    String namePlayer = "";
    default String showName() {
        System.out.println(this);
        return namePlayer;
    }

    //ArrayList for every generated or already available team

    String role = "";
    default String play() {
        System.out.println(this);
        return role;
    };

    String team = "";
    default String teamName() {
        System.out.println(this);
        return team;
    }



    //these are more complicated
    default String createNewTeam() {

        ArrayList<String> newTeamList = new ArrayList<>();

        String input;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter team-members (type 'end' to stop):");
            while (!(input = scanner.nextLine()).equals("end")) {
                newTeamList.add(input);
            }
        }

        System.out.println("The ArrayList contains: " + newTeamList);

        //newTeamList.stream(member).forEach(member -> System.out.println(member));
        //System.out.println("The ArrayList contains: " + newTeamList);
        return this.team;
    };


    default String createNewPlayer() {
        ArrayList<String> newPlayerList = new ArrayList<>();
        String input;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter player name:");
            while (!(input = scanner.nextLine()).equals("end")) {
                newPlayerList.add(input);
            }
        }
        System.out.println("The ArrayList contains: " + newPlayerList);
        return input;
    };


    //how to add to arrayList?
    //as a for loop maybe, to fill it up according to index




}
