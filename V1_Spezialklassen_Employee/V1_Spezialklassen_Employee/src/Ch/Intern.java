package Ch;

/**
 * Intern, a special form of {@link Employee}.
 * Gets a fixed wage and may not work more than {@code maxHours}.
 */
public class Intern extends Employee {


    /** Maximum number of hours an intern may work. */
    private double maxHours = 50;

    /**
     * Creates a new intern.
     *
     * @param name   name of the intern
     * @param id     unique id of the intern
     * @param salary fixed wage of the intern
     * @param hours  number of hours worked
     */
    public Intern(String name, Integer id, double salary, double hours) {
        super(name, id, salary, hours);
    }


    /**
     * Calculates the fixed wage of the intern and prints it.
     * If the hours are greater than {@code maxHours}, they are set back to {@code maxHours}.
     *
     * @return the fixed wage
     */
    public double internWageCalc() {
        System.out.println("========================");
        // Makes sure the maximum hours are never exceeded
        if (super.getHours() > maxHours) {
            System.out.println("Hours is greater than max Hours, hours set to " + maxHours);
            setHours(maxHours);
        }
        // Intern has a fixed wage, independent of the hours
        double wage = getSalary();
        System.out.println("Employee id = " + this.getId());
        System.out.println("Employee name = " + this.getName());
        System.out.println("Wage is: " + wage);
        return wage;


    }

    /**
     * Calculates the pay of the intern, see {@link #internWageCalc()}.
     *
     * @return the fixed wage
     */
    @Override
    public double calculatePay() {
        return internWageCalc();
    }

    /**
     * Returns the maximum hours.
     *
     * @return the maximum number of hours
     */
    public double getMaxHours() {
        return maxHours;
    }

    /**
     * Sets the maximum hours.
     *
     * @param maxHours the new maximum number of hours
     */
    public void setMaxHours(double maxHours) {
        this.maxHours = maxHours;
    }




}
