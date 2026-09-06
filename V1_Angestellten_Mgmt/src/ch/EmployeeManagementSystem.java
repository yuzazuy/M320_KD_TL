package ch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private List<Employee> employees;
    private List<FullTimeEmployee> fullTimeEmployees;
    private List<PartTimeEmployee> partTimeEmployees;
    private List<Intern> interns;
    private Scanner scanner;

    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
        this.fullTimeEmployees = new ArrayList<>();
        this.partTimeEmployees = new ArrayList<>();
        this.interns = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);

        if (employee instanceof FullTimeEmployee) {
            fullTimeEmployees.add((FullTimeEmployee) employee);
            System.out.println("FullTime-Mitarbeiter hinzugefügt: " + employee.getName());
        } else if (employee instanceof PartTimeEmployee) {
            partTimeEmployees.add((PartTimeEmployee) employee);
            System.out.println("PartTime-Mitarbeiter hinzugefügt: " + employee.getName());
        } else if (employee instanceof Intern) {
            interns.add((Intern) employee);
            System.out.println("Praktikant hinzugefügt: " + employee.getName());
        }
    }

    public void displayAllEmployees() {
        System.out.println("\n=== Alle Mitarbeiter ===");
        System.out.println("Gesamtanzahl: " + employees.size());
        System.out.println("------------------------");

        for (Employee emp : employees) {
            if (emp instanceof FullTimeEmployee) {
                ((FullTimeEmployee) emp).calculateAndDisplayPay();
            } else if (emp instanceof PartTimeEmployee) {
                ((PartTimeEmployee) emp).displayPartTimeInfo();
            } else if (emp instanceof Intern) {
                ((Intern) emp).displayInternInfo();
            }
        }
    }

    public Employee searchEmployeeByName(String name) {
        for (Employee emp : employees) {
            if (emp.getName().equalsIgnoreCase(name)) {
                return emp;
            }
        }
        return null;
    }

    public Employee searchEmployeeById(String id) {
        for (Employee emp : employees) {
            if (emp.getId().equalsIgnoreCase(id)) {
                return emp;
            }
        }
        return null;
    }

    public List<Employee> getEmployeesByType(Class<?> type) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employees) {
            if (type.isInstance(emp)) {
                result.add(emp);
            }
        }
        return result;
    }

    public List<FullTimeEmployee> getFullTimeEmployees() {
        return fullTimeEmployees;
    }

    public List<PartTimeEmployee> getPartTimeEmployees() {
        return partTimeEmployees;
    }

    public List<Intern> getInterns() {
        return interns;
    }

    public void userSearchMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Mitarbeiter-Suche ===");
            System.out.println("1. Nach Name suchen");
            System.out.println("2. Nach ID suchen");
            System.out.println("3. Alle Mitarbeiter anzeigen");
            System.out.println("4. Nach Mitarbeitertyp filtern");
            System.out.println("5. Mitarbeiterstatistik anzeigen");
            System.out.println("6. Zurück zum Hauptmenü");
            System.out.print("Ihre Wahl: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Buffer leeren

            switch (choice) {
                case 1:
                    searchByName();
                    break;
                case 2:
                    searchById();
                    break;
                case 3:
                    displayAllEmployees();
                    break;
                case 4:
                    filterByType();
                    break;
                case 5:
                    displayStatistics();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Eingabe!");
            }
        }
    }

    private void searchByName() {
        System.out.print("Geben Sie den Namen ein: ");
        String name = scanner.nextLine();
        Employee emp = searchEmployeeByName(name);

        if (emp != null) {
            System.out.println("\n=== Mitarbeiter gefunden ===");
            emp.displayInfo();
        } else {
            System.out.println("Kein Mitarbeiter mit dem Namen '" + name + "' gefunden.");
        }
    }

    private void searchById() {
        System.out.print("Geben Sie die ID ein: ");
        String id = scanner.nextLine();
        Employee emp = searchEmployeeById(id);

        if (emp != null) {
            System.out.println("\n=== Mitarbeiter gefunden ===");
            emp.displayInfo();
        } else {
            System.out.println("Kein Mitarbeiter mit der ID '" + id + "' gefunden.");
        }
    }

    private void filterByType() {
        System.out.println("\n=== Nach Typ filtern ===");
        System.out.println("1. FullTime Mitarbeiter");
        System.out.println("2. PartTime Mitarbeiter");
        System.out.println("3. Praktikanten");
        System.out.print("Ihre Wahl: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                displayEmployeesByType(FullTimeEmployee.class);
                break;
            case 2:
                displayEmployeesByType(PartTimeEmployee.class);
                break;
            case 3:
                displayEmployeesByType(Intern.class);
                break;
            default:
                System.out.println("Ungültige Eingabe!");
        }
    }

    private void displayEmployeesByType(Class<?> type) {
        List<Employee> filtered = getEmployeesByType(type);
        System.out.println("\n=== Gefundene Mitarbeiter (" + filtered.size() + ") ===");
        for (Employee emp : filtered) {
            System.out.println("- " + emp.getName() + " (" + emp.getId() + ")");
        }
    }

    private void displayStatistics() {
        System.out.println("\n=== Mitarbeiterstatistik ===");
        System.out.println("Gesamtanzahl Mitarbeiter: " + employees.size());
        System.out.println("FullTime Mitarbeiter: " + fullTimeEmployees.size());
        System.out.println("PartTime Mitarbeiter: " + partTimeEmployees.size());
        System.out.println("Praktikanten: " + interns.size());

        double totalSalary = 0;
        for (Employee emp : employees) {
            totalSalary += emp.calculatePay();
        }
        double averageSalary = employees.isEmpty() ? 0 : totalSalary / employees.size();
        System.out.printf("Durchschnittsgehalt: %.2f CHF\n", averageSalary);
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();

        system.createTestData();

        system.userSearchMenu();

        system.scanner.close();
    }

    private void createTestData() {
        FullTimeEmployee emp1 = new FullTimeEmployee("Max Mustermann", "E001", 45000, true);
        FullTimeEmployee emp2 = new FullTimeEmployee("Anna Schmidt", "E002", 52000, false);
        FullTimeEmployee emp3 = new FullTimeEmployee("Thomas Weber", "E003", 48000, true, 1500);

        PartTimeEmployee emp4 = new PartTimeEmployee("Lisa Müller", "E004", 0, 25.50, 80);
        PartTimeEmployee emp5 = new PartTimeEmployee("Peter Wagner", "E005", 0, 30.00, 65);

        Intern emp6 = new Intern("Lukas Müller", "I010", 0, 16.50, 21, 25);
        Intern emp7 = new Intern("Charlotte Hefti", "I011", 0, 18.50, 16, 35);
        Intern emp8 = new Intern("Paule Teulette", "I012", 0, 13.00, 18, 13);

        addEmployee(emp1);
        addEmployee(emp2);
        addEmployee(emp3);
        addEmployee(emp4);
        addEmployee(emp5);
        addEmployee(emp6);
        addEmployee(emp7);
        addEmployee(emp8);
    }
}