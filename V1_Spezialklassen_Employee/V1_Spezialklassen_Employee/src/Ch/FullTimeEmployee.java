package Ch;

/**
 * Full-time employee, a special form of {@link Employee}.
 * Is paid by hourly rate and can get an additional bonus.
 */
public class FullTimeEmployee  extends Employee {
    /** Pay per hour. */
    private double hourly_rate;
    /** Number of hours worked. */
    private double hours_worked;
    /** True if the employee gets a bonus. */
    private boolean hasBonus;
    /** Amount of the bonus. */
    private double Bonus;



    /**
     * Creates a new full-time employee.
     *
     * @param name         name of the employee
     * @param id           unique id of the employee
     * @param salary       salary (passed to {@link Employee})
     * @param hours        hours (passed to {@link Employee})
     * @param hourly_rate  pay per hour
     * @param hours_worked number of hours worked
     * @param hasBonus     true if the employee gets a bonus
     * @param bonus        amount of the bonus
     */
    public FullTimeEmployee(String name, Integer id, double salary, double hours, double hourly_rate, double hours_worked, boolean hasBonus, double bonus) {
        super(name, id, salary, hours);
        this.hourly_rate = hourly_rate;
        this.hours_worked = hours_worked;
        this.hasBonus = hasBonus;
        Bonus = bonus;
    }

    /**
     * Calculates hourly rate multiplied by hours worked (without bonus) and prints it.
     *
     * @return the pay without bonus
     */
    public double calculate_pay() {
        double rate = hourly_rate * hours_worked;
        System.out.println("========================");
        System.out.println("Employee id = " + this.getId());
        System.out.println("Employee name = " + this.getName());
        System.out.println("Rate is: " + rate);
        return rate;
    };

    /**
     * Calculates the pay and adds the bonus if the employee has one.
     *
     * @return the pay including the bonus
     */
    @Override
    public double calculatePay() {
        double pay = calculate_pay();
        // The bonus is only added if hasBonus is true
        if (hasBonus) {
            pay = pay + Bonus;
            System.out.println("Pay with bonus is: " + pay);
        }
        return pay;
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
     * Tells if the employee gets a bonus.
     *
     * @return true if the employee gets a bonus
     */
    public boolean isHasBonus() {
        return hasBonus;
    }

    /**
     * Returns the bonus.
     *
     * @return the amount of the bonus
     */
    public double getBonus() {
        return Bonus;
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

    /**
     * Sets if the employee gets a bonus.
     *
     * @param hasBonus true if the employee gets a bonus
     */
    public void setHasBonus(boolean hasBonus) {
        this.hasBonus = hasBonus;
    }

    /**
     * Sets the bonus.
     *
     * @param bonus the new amount of the bonus
     */
    public void setBonus(double bonus) {
        Bonus = bonus;
    }
}
