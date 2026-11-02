package ch;
import java.util.Scanner;

/**
 * Heater with a temperature that can be raised or lowered within a min and max range.
 */
public class Heater {
    /** Current temperature. */
    private int temperature;
    /** Lowest allowed temperature. */
    private int min;
    /** Highest allowed temperature. */
    private int max;
    /** Step size for raising or lowering the temperature. */
    private int increment;


    /**
     * Creates a new heater.
     *
     * @param temperature start temperature
     * @param min         lowest allowed temperature
     * @param max         highest allowed temperature
     * @param increment   step size for raising or lowering
     */
    public Heater(int temperature, int min, int max, int increment) {
        this.temperature = temperature;
        this.min = min;
        this.max = max;
        this.increment = increment;
    }


    /**
     * Shows all heaters and lets the user choose one.
     * Asks again until the input is a valid number.
     *
     * @param heaters all heaters to choose from
     * @param scanner scanner that reads the user input
     * @return the chosen heater
     */
    public static Heater selectHeater(Heater[] heaters, Scanner scanner) {
        System.out.println("Choose a heater:");
        for (int i = 0; i < heaters.length; i++) {
            Heater h = heaters[i];
            System.out.println((i + 1) + ": Temp=" + h.getTemperature()
                    + " Min=" + h.getMin() + " Max=" + h.getMax());
        }
        System.out.println("Your answer here: ");

        int choice = -1;
        // Repeat until the choice is a valid index
        while (choice < 0 || choice >= heaters.length) {
            String input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input) - 1;
            } catch (NumberFormatException e) {
                choice = -1;
            }
            if (choice < 0 || choice >= heaters.length) {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        return heaters[choice];
    }

    /**
     * Lets the user raise (+) or lower (-) the temperature until they stop.
     * The temperature never goes below min or above max.
     *
     * @param scanner scanner that reads the user input
     */
    public void userInput(Scanner scanner) {
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

            // Only change the temperature if it stays inside the range
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

        }




    }






    /**
     * Returns the temperature.
     *
     * @return the current temperature
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * Returns the minimum.
     *
     * @return the lowest allowed temperature
     */
    public int getMin() {
        return min;
    }

    /**
     * Returns the maximum.
     *
     * @return the highest allowed temperature
     */
    public int getMax() {
        return max;
    }

    /**
     * Returns the increment.
     *
     * @return the step size
     */
    public int getIncrement() {
        return increment;
    }


    /**
     * Sets the temperature.
     *
     * @param temperature the new temperature
     */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    /**
     * Sets the minimum.
     *
     * @param min the new lowest allowed temperature
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * Sets the maximum.
     *
     * @param max the new highest allowed temperature
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * Sets the increment.
     *
     * @param increment the new step size
     */
    public void setIncrement(int increment) {
        this.increment = increment;
    }
}