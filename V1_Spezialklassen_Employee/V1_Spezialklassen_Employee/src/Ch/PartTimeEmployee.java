package Ch;

/**
 * Part-time employee, a special form of {@link Employee}.
 * Is paid by hourly rate multiplied by hours worked.
 */
public class PartTimeEmployee extends Employee {

    /** Pay per hour. */
    private double hourly_rate;
    /** Number of hours worked. */
    private double hours_worked;

    /**
     * Creates a new part-time employee.
     *
     * @param name         name of the employee
     * @param id           unique id of the employee
     * @param salary       salary (passed to {@link Employee})
     * @param hours        hours (passed to {@link Employee})
     * @param hourly_rate  pay per hour
     * @param hours_worked number of hours worked
     */
    public PartTimeEmployee(String name, Integer id, double salary, double hours, double hourly_rate, double hours_worked) {
        super(name, id, salary, hours);
        this.hourly_rate = hourly_rate;
        this.hours_worked = hours_worked;
    }

    /**
     * Calculates hourly rate multiplied by hours worked and prints it.
     *
     * @return the pay of the part-time employee
     */
    public double calculate_rate() {
        double rate =  hourly_rate * hours_worked;
        System.out.println("========================");
        System.out.println("Employee id = " + this.getId());
        System.out.println("Employee name = " + this.getName());
        System.out.println("Part-time rate: " + rate);
        return rate;
    }

    /**
     * Calculates the pay of the part-time employee, see {@link #calculate_rate()}.
     *
     * @return the pay of the part-time employee
     */
    @Override
    public double calculatePay() {
        return calculate_rate();
    }

    /**
     * Returns the hourly rate.
     *
     * @return the pay per hour
     */
    public double getHourly_rate() {
        return hourly_rate;
    }

    /**
     * Returns the hours worked.
     *
     * @return the number of hours worked
     */
    public double getHours_worked() {
        return hours_worked;
    }

    /**
     * Sets the hourly rate.
     *
     * @param hourly_rate the new pay per hour
     */
    public void setHourly_rate(double hourly_rate) {
        this.hourly_rate = hourly_rate;
    }

    /**
     * Sets the hours worked.
     *
     * @param hours_worked the new number of hours
     */
    public void setHours_worked(double hours_worked) {
        this.hours_worked = hours_worked;
    }
}
