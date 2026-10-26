package ch;
import java.util.Scanner;

/**
 * Starts the D1 exercise: lets the user choose heaters and change their temperature.
 */
public class Main {
    /**
     * Entry point of the program.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        Heater myObj = new Heater(19, 0, 35, 1);
        Heater myObj2 = new Heater(20, 3, 40, 5);
        Heater myObj3 = new Heater(30, 4, 40, 9);

        Heater[] heaters = { myObj, myObj2, myObj3 };

        // One scanner for the whole program, closed at the end
        Scanner scanner = new Scanner(System.in);

        boolean programRunning;
        programRunning = true;

        while (programRunning) {


            Heater selected = Heater.selectHeater(heaters, scanner);
            selected.userInput(scanner);
            System.out.println("Choose another heater (1) or quit program (0):");
            String answer = scanner.nextLine();

            if (answer.equals("1")) {
                continue;
            } else if (answer.equals("0")) {
                programRunning = false;
            } else {
                // Ask again until the answer is valid
                while (!answer.equals("0") && !answer.equals("1")) {
                    System.out.println("Invalid choice");
                    System.out.println("Choose another heater (1) or quit program (0):");
                    answer = scanner.nextLine();
                }
                if (answer.equals("0")) {
                    programRunning = false;
                }
            }


        }


        scanner.close();
    }
}

