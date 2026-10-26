package Ch;

import java.math.BigDecimal;

/**
 * Base class of all employees.
 * Holds the general attributes that every employee has.
 * The subclasses override {@link #calculatePay()} with their own pay calculation.
 */
public class Employee {

    /** Name of the employee. */
    private String name;
    /** Unique id of the employee. */
    private Integer id;
    /** Pay per hour of the employee. */
    private double salary;
    /** Number of hours the employee worked. */
    private double hours;

    /**
     * Creates a new employee.
     *
     * @param name   name of the employee
     * @param id     unique id of the employee
     * @param salary pay per hour
     * @param hours  number of hours worked
     */
    public Employee(String name, Integer id, double salary, double hours) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.hours = hours;
    }

    /**
     * Calculates the pay as salary multiplied by hours and prints it.
     *
     * @return the calculated pay
     */
    public double calculatePay() {
        double pay = this.salary * this.hours;
        System.out.println("========================");
        System.out.println("Employee id = " + this.id);
        System.out.println("Employee name = " + this.getName());
        System.out.println("Employee pay is: " + pay);
        return pay;
    };

    /**
     * Returns the name.
     *
     * @return the name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the id.
     *
     * @return the id of the employee
     */
    public Integer getId() {
        return id;
    }

    /**
     * Returns the salary.
     *
     * @return the pay per hour
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Returns the hours worked.
     *
     * @return the number of hours worked
     */
    public double getHours() {
        return hours;
    }



    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Sets the salary.
     *
     * @param salary the new pay per hour
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Sets the hours worked.
     *
     * @param hours the new number of hours
     */
    public void setHours(double hours) {
        this.hours = hours;
    }


}
