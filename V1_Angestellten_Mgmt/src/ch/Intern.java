package ch;

public class Intern extends Employee {
    private double maxHours;
    private double fixedHourlyRate;
    private double hoursWorked;

    public Intern(String name, String id, double salary, double fixedHourlyRate, double hoursWorked, double maxHours) {
        super(name, id, salary);
        this.maxHours = maxHours;
        this.fixedHourlyRate = fixedHourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getMaxHours() {
        return maxHours;
    }

    public void setMaxHours(double maxHours) {
        this.maxHours = maxHours;
    }

    public double getFixedHourlyRate() {
        return fixedHourlyRate;
    }

    public void setFixedHourlyRate(double fixedHourlyRate) {
        this.fixedHourlyRate = fixedHourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

//    public double calculateRate() {
//        return fixedHourlyRate * hoursWorked;
//    }

    public double calculateRate() {
        double rate = fixedHourlyRate * hoursWorked;
        double overWorked = hoursWorked - maxHours;
        double overWorkedMoney = overWorked * fixedHourlyRate;
        if (hoursWorked > maxHours) {
            return rate - overWorkedMoney;
        }
        return rate;
    }

    @Override
    public double calculatePay() {
        return calculateRate();
    }

    public void displayInternInfo() {
        System.out.println("=== Intern Employee ===");
        displayInfo();
        System.out.println("Stundensatz: " + fixedHourlyRate);
        System.out.println("Arbeitsstunden: " + hoursWorked);
        System.out.printf("Max. Arbeitsstunden: " + maxHours);
        if (hoursWorked > maxHours) {
            System.out.println("\nDu hast deine max. Stundenzahl erreicht. \nBei Vorgesetzer melden.");
        }
        System.out.println("\n------------------------\n");
    }
}
