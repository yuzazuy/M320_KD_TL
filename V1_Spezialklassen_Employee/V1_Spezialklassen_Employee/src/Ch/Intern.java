package Ch;

public class Intern extends Employee {


    private double maxHours = 50;

    public Intern(String name, Integer id, double salary, double hours) {
        super(name, id, salary, hours);
    }


    public double internWageCalc() {
        System.out.println("========================");
        if (super.getHours() >= maxHours) {
            System.out.println("Hours is greater than max Hours");

        }
        double wage = getSalary() * this.getHours();
        System.out.println("Employee id = " + this.getId());
        System.out.println("Employee name = " + this.getName());
        System.out.println("Wage is: " + wage);
        return wage;


    }




}
