package ch;

public class FullTimeEmployee extends Employee {
    private boolean hasBonus;
    private double bonusAmount;

    public FullTimeEmployee(String name, String id, double salary, boolean hasBonus) {
        super(name, id, salary);
        this.hasBonus = hasBonus;
        this.bonusAmount = 1000.0; // Standard-Bonus
    }

    public FullTimeEmployee(String name, String id, double salary, boolean hasBonus, double bonusAmount) {
        super(name, id, salary);
        this.hasBonus = hasBonus;
        this.bonusAmount = bonusAmount;
    }

    public boolean isHasBonus() {
        return hasBonus;
    }

    public void setHasBonus(boolean hasBonus) {
        this.hasBonus = hasBonus;
    }

    public double getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(double bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    @Override
    public double calculatePay() {
        double basePay = getSalary();
        if (hasBonus) {
            return basePay + bonusAmount;
        }
        return basePay;
    }

    public void calculateAndDisplayPay() {
        System.out.println("=== FullTime Employee ===");
        displayInfo();
        System.out.println("Bonus erhalten: " + (hasBonus ? "Ja" : "Nein"));
        System.out.println("Bonus-Betrag: " + (hasBonus ? bonusAmount : 0));
        System.out.println("\n------------------------");
    }
}
