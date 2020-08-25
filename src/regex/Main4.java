package regex;

public class Main4 {
    static void employeeInfo(Employee e) {
        System.out.printf("%03d \t %-12s \t %-12s \t %,.1f \n", e.id, e.name, e.surname, e.salary * (1 + e.bonus));
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Vika", "Sham", 12345, 0.35);
        Employee e2 = new Employee(2, "Bega", "Shamur", 65478, 0.13);
        Employee e3 = new Employee(3, "Ivan", "Iv", 1256345, 0.1);
        employeeInfo(e1);
        employeeInfo(e2);
        employeeInfo(e3);

        String newStr = String.format("%03d \t %-12s \t %-12s \t %,.1f \n", 1,"Vika", "Shamuradova", 12345.6);
        System.out.println(newStr);
    }
}

class Employee {
    int id;
    String name;
    String surname;
    int salary;
    double bonus;

    public Employee(int id, String name, String surname, int salary, double bonus) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.bonus = bonus;
    }
}