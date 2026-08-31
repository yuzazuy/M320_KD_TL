package Ch;

public class Intern extends Employee {


    private double maxHours;

    public Intern(String name, Integer id, double salary, double hours) {
        super(name, id, salary, hours);
    }


    public double internWageCalc() {
        double wage = getSalary() * maxHours;
        System.out.println("Wage is: " + super.getName() + " " + wage);
        return wage;
    }




}
