package ch;
import java.util.Scanner;

public class Heater {
    private int temperature;
    private int min;
    private int max;
    private int increment;


    public Heater(int temperature, int min, int max, int increment) {
        this.temperature = temperature;
        this.min = min;
        this.max = max;
        this.increment = increment;
    }


    public void userInput() {
        Scanner scanner = new Scanner(System.in);
        String input;


        boolean startCondition = true;


        while (startCondition == true) {
            System.out.println("Temperature: " + this.getTemperature());
            System.out.println("Min: " + this.getMin());
            System.out.println("Max: " + this.getMax());
            System.out.println("Increment: " + this.getIncrement());
            System.out.println(" ");
            System.out.println("Would you like to change temperature?");
            System.out.println("Press + to increase, - to decrease:");
            System.out.println("Your answer here: ");

            input = scanner.nextLine();

            if ((input.equals("+")) && (this.getTemperature() + this.getIncrement() <= this.getMax())) {
                this.setTemperature(this.getTemperature() + this.getIncrement());
                System.out.println("Your temperature is: " + this.getTemperature());
            } else if ((input.equals("-")) && (this.getTemperature() - this.getIncrement() >= this.getMin())) {
                this.setTemperature(this.getTemperature() - this.getIncrement());
                System.out.println("Your temperature is: " + this.getTemperature());
            } else {
                System.out.println("Range limits crossed. Please try again.");
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
            //break;
        }
        scanner.close();
    }






    public int getTemperature() {
        return temperature;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getIncrement() {
        return increment;
    }


    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
    }
}