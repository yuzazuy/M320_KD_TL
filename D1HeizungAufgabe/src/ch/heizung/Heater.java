


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

//            if (temperature > max) {
//                System.out.println("The temperature is greater than the maximum temperature.");
//            } else if (temperature < min) {
//                System.out.println("The temperature is less than the minimum temperature.");
//            }


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
 