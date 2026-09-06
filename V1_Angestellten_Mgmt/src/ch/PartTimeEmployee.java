package ch;

public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    public PartTimeEmployee(String name, String id, double salary, double hourlyRate, double hoursWorked) {
        super(name, id, salary);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double calculateRate() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public double calculatePay() {
        return calculateRate();
    }

    public void displayPartTimeInfo() {
        System.out.println("=== PartTime Employee ===");
        displayInfo();
        System.out.println("Stundensatz: " + hourlyRate);
        System.out.println("Arbeitsstunden: " + hoursWorked);
        System.out.println("\n------------------------");
    }
}
