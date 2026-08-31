package Ch;

public class FullTimeEmployee  extends Employee {
    private double hourly_rate;
    private double hours_worked;
    private boolean hasBonus;
    private double Bonus;



    public FullTimeEmployee(String name, Integer id, double salary, double hours, double hourly_rate, double hours_worked, boolean hasBonus, double bonus) {
        super(name, id, salary, hours);
        this.hourly_rate = hourly_rate;
        this.hours_worked = hours_worked;
        this.hasBonus = hasBonus;
        Bonus = bonus;
    }

    public double calculate_pay() {
        double rate = hourly_rate * hours_worked;
        System.out.println("Rate is: " + super.getName() + " " + rate);
        return rate;
    };

    public double getHourly_rate() {
        return hourly_rate;
    }

    public double getHours_worked() {
        return hours_worked;
    }

    public boolean isHasBonus() {
        return hasBonus;
    }

    public double getBonus() {
        return Bonus;
    }

    public void setHourly_rate(double hourly_rate) {
        this.hourly_rate = hourly_rate;
    }

    public void setHours_worked(double hours_worked) {
        this.hours_worked = hours_worked;
    }

    public void setHasBonus(boolean hasBonus) {
        this.hasBonus = hasBonus;
    }

    public void setBonus(double bonus) {
        Bonus = bonus;
    }
}
