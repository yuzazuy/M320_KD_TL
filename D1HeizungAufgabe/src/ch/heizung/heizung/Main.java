package heizung;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        Heater myObj = new Heater(19, 0, 35, 1);

        boolean startCondition = true;

        do {
            System.out.println("Temperature: " + myObj.getTemperature());
            System.out.println("Min: " + myObj.getMin());
            System.out.println("Max: " + myObj.getMax());
            System.out.println("Increment: " + myObj.getIncrement());
            System.out.println(" ");
            System.out.println("Would you like to change temperature?");
            System.out.println("Press + to increase, - to decrease:");
            System.out.println("Your answer here: ");
            input = scanner.nextLine();

            if (input.equals("+")) {
                myObj.setTemperature(myObj.getTemperature() + myObj.getIncrement());
                System.out.println("Your temperature is: " + myObj.getTemperature());
            } else if (input.equals("-")) {
                myObj.setTemperature(myObj.getTemperature() - myObj.getIncrement());
                System.out.println("Your temperature is: " + myObj.getTemperature());
            } else if (myObj.getTemperature() > myObj.getMax()) {
                System.out.println("The temperature is greater than the maximum temperature.");
            } else if (myObj.getTemperature() < myObj.getMin()) {
                System.out.println("The temperature is less than the minimum temperature.");
            } else {
                System.out.println("Invalid input. Please try again.");
            }

            System.out.println("Would you like to continue?");
            System.out.println("Type 0 for no, type 1 for yes");
            input = scanner.nextLine();

            if (input.equals("0")) {
                startCondition = false;
            } else if (input.equals("1")) {
                continue;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
            break;
        } while(startCondition);
        scanner.close();
    }
}


