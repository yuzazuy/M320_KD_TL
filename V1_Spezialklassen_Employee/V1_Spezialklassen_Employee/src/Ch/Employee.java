package Ch;

import java.math.BigDecimal;

public class Employee {

    private String name;
    private Integer id;
    private double salary;
    private double hours;

    public Employee(String name, Integer id, double salary, double hours) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.hours = hours;
    }

    public double calculatePay() {
        double pay = this.salary * this.hours;
        System.out.println("Employyee pay is: " + name + " " + pay);
        return pay;
    };

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public double getHours() {
        return hours;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }


}
