package Ch;

/**
 * Starts the V1 exercise: creates employees and prints their pay.
 */
public class Main {
    /**
     * Entry point of the program.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

    // Task 1: one object per employee type, each calculates its own pay
    Employee Jessika = new Employee("Jessika", 01, 300000, 40);
    Jessika.calculatePay();
    PartTimeEmployee Paul = new PartTimeEmployee("Paul", 02, 40000, 50, 400, 999);
    Paul.calculate_rate();
    FullTimeEmployee Mother = new FullTimeEmployee("Mother", 03,500000, 555,555,555,true, 5000);
    Mother.calculate_pay();
    Intern Alina = new Intern("Alina", 04, 44444, 56);
    Alina.internWageCalc();

    // Task 2: EmployeeManager with one list per subclass
    System.out.println("======== EmployeeManager ========");
    EmployeeManager manager = new EmployeeManager();
    manager.addPartTimeEmployee(Paul);
    manager.addFullTimeEmployee(Mother);
    manager.addIntern(Alina);
    manager.printAllPays();





    }

}
