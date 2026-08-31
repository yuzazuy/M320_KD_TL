package Ch;

public class PartTimeEmployee extends Employee {

    private double hourly_rate;
    private double hours_worked;

    public PartTimeEmployee(String name, Integer id, double salary, double hours, double hourly_rate, double hours_worked) {
        super(name, id, salary, hours);
        this.hourly_rate = hourly_rate;
        this.hours_worked = hours_worked;
    }

    public double calculate_rate() {
        double rate =  hourly_rate * hours_worked;
        System.out.println("========================");
        System.out.println("Employee name = " + this.getName());
        System.out.println("Fulltime rate: " + rate);
        return rate;
    }

    public double getHourly_rate() {
        return hourly_rate;
    }

    public double getHours_worked() {
        return hours_worked;
    }

    public void setHourly_rate(double hourly_rate) {
        this.hourly_rate = hourly_rate;
    }

    public void setHours_worked(double hours_worked) {
        this.hours_worked = hours_worked;
    }
}
