import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];

        employees[0] = new Employee("Иванов", "Иван", "Иванович",
                10_000, "1");
        employees[1] = new Employee("Петров", "Петр", "Петрович",
                11_000, "2");
        employees[2] = new Employee("Сидоров", "Сидор", "Сидорович",
                12_000, "3");

        printEmployees(employees);
        System.out.println();

        System.out.printf("Рассходы на заработную плату сотрудников составляют %d рублей %n",
                calculateSalarySum(employees));
        System.out.println();

        findEmployeeWithMinSalary(employees);
        System.out.println();

        findEmployeeWithMaxSalary(employees);
        System.out.println();

        printAverageSalary(employees);
        System.out.println();

        System.out.println("Список ФИО всех сотрудников:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            System.out.printf("%s %s %s %n", employees[i].getLastName(), employees[i].getFirstName(),
                    employees[i].getMiddleName());
        }
    }

    public static void printEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    public static int calculateSalarySum(Employee[] employees) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            sum += employees[i].getSalary();
        }
        return sum;
    }

    public static void findEmployeeWithMinSalary (Employee[] employees) {
        int minSalary = employees[0].getSalary();
        Employee employeeWithMinSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() <= minSalary) {
                minSalary = employees[i].getSalary();
                employeeWithMinSalary = employees[i];
            }
        }
        System.out.printf("Сотрудник с минимальной зарплатой:%n %s%n", employeeWithMinSalary);
    }

    public static void findEmployeeWithMaxSalary (Employee[] employees) {
        int maxSalary = employees[0].getSalary();
        Employee employeeWithMaxSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() >= maxSalary) {
                maxSalary = employees[i].getSalary();
                employeeWithMaxSalary = employees[i];
            }
        }
        System.out.printf("Сотрудник с максимальной зарплатой:%n %s%n", employeeWithMaxSalary);
    }

    public static void printAverageSalary(Employee[] employees) {
        System.out.printf("Средняя зарплата составляет %d%n", calculateSalarySum(employees) / Employee.getCounter());
    }
}