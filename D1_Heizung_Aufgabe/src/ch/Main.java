package ch;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Heater myObj = new Heater(19, 0, 35, 1);
        Heater myObj2 = new Heater(20, 3, 40, 5);
        Heater myObj3 = new Heater(30, 4, 40, 9);

        Heater[] heaters = { myObj, myObj2, myObj3 };

        Scanner scanner = new Scanner(System.in);

        boolean programRunning;
        programRunning = true;

        while (programRunning) {


            Heater selected = Heater.selectHeater(heaters, scanner);
            selected.userInput(scanner);
            System.out.println("Choose another heater (1) or quit program (0):");
            String answer = scanner.next();

            if (answer.equals("1")) {
                continue;
            } else if (answer.equals("0")) {
                programRunning = false;
            } else {
                System.out.println("Invalid choice");
            }


        }


        scanner.close();
    }
}

