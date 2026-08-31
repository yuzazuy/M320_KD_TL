package Ch;

public class Intern extends Employee {


    private double maxHours = 50;

    public Intern(String name, Integer id, double salary, double hours) {
        super(name, id, salary, hours);
    }


    public double internWageCalc() {
        if (super.getHours() >= maxHours) {
            System.out.println("Hours is greater than max Hours");

        } else {
        double wage = getSalary() * maxHours;
        System.out.println("Wage is: " + super.getName() + " " + wage);
        return wage;
        }
       return 0;
    }




}
