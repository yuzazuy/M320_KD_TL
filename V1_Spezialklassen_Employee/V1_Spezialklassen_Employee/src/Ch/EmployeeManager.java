package Ch;

import java.util.ArrayList;

/**
 * Central class that manages all employees.
 * There is one list per subclass (V2 shows how to do this with one list thanks to polymorphism).
 */
public class EmployeeManager {

    /** All full-time employees. */
    private ArrayList<FullTimeEmployee> fullTimeEmployees = new ArrayList<>();
    /** All part-time employees. */
    private ArrayList<PartTimeEmployee> partTimeEmployees = new ArrayList<>();
    /** All interns. */
    private ArrayList<Intern> interns = new ArrayList<>();

    /**
     * Adds a full-time employee to its list.
     *
     * @param employee the employee to add
     */
    public void addFullTimeEmployee(FullTimeEmployee employee) {
        fullTimeEmployees.add(employee);
    }

    /**
     * Adds a part-time employee to its list.
     *
     * @param employee the employee to add
     */
    public void addPartTimeEmployee(PartTimeEmployee employee) {
        partTimeEmployees.add(employee);
    }

    /**
     * Adds an intern to its list.
     *
     * @param intern the intern to add
     */
    public void addIntern(Intern intern) {
        interns.add(intern);
    }

    /**
     * Calculates and prints the pay of every employee in all three lists.
     */
    public void printAllPays() {
        for (FullTimeEmployee employee : fullTimeEmployees) {
            employee.calculatePay();
        }
        for (PartTimeEmployee employee : partTimeEmployees) {
            employee.calculatePay();
        }
        for (Intern intern : interns) {
            intern.calculatePay();
        }
    }

    /**
     * Returns the list of full-time employees.
     *
     * @return all full-time employees
     */
    public ArrayList<FullTimeEmployee> getFullTimeEmployees() {
        return fullTimeEmployees;
    }

    /**
     * Returns the list of part-time employees.
     *
     * @return all part-time employees
     */
    public ArrayList<PartTimeEmployee> getPartTimeEmployees() {
        return partTimeEmployees;
    }

    /**
     * Returns the list of interns.
     *
     * @return all interns
     */
    public ArrayList<Intern> getInterns() {
        return interns;
    }
}
