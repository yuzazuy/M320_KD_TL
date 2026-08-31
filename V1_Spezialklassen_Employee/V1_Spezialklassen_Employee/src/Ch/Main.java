package Ch;

public class Main {
    public static void main(String[] args) {

    Employee Jessika = new Employee("Jessika", 01, 300000, 40);
    Jessika.calculatePay();
    PartTimeEmployee Paul = new PartTimeEmployee("Paul", 02, 40000, 50, 400, 999);
    Paul.calculate_rate();
    FullTimeEmployee Mother = new FullTimeEmployee("Mother", 03,500000, 555,555,555,true, 5000);
    Mother.calculate_pay();
    Intern Alina = new Intern("Alina", 04, 44444, 56);
    Alina.internWageCalc();





    }

}
