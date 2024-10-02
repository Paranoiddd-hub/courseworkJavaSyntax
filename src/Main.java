public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];

        employees[0] = new Employee("Иванов", "Иван", "Иванович",
                10_000, "1");
        employees[1] = new Employee("Петров", "Петр", "Петрович",
                11_000, "1");
        employees[2] = new Employee("Сидоров", "Сидор", "Сидорович",
                12_000, "1");
        employees[3] = new Employee("Мажоров", "Мажор", "Мажорович",
                120_000, "2");

        printEmployees(employees);
        System.out.println();

        System.out.printf("Рассходы на заработную плату сотрудников составляют %d рублей %n",
                calculateSalarySum(employees));
        System.out.println();

        System.out.printf("Сотрудник с минимальной зарплатой:%n %s%n", findEmployeeWithMinSalary(employees));
        System.out.println();

        System.out.printf("Сотрудник с максимальной зарплатой:%n %s%n", findEmployeeWithMaxSalary(employees));
        System.out.println();

        System.out.printf("Средняя зарплата составляет %.0f %n", findAverageSalary(employees));
        System.out.println();

        System.out.println("Список ФИО всех сотрудников:");
        printEmployeesNames(employees);
        System.out.println();


        // Повышенная сложность
        System.out.println("\t Повышенная сложность");

        System.out.println("\t Текущие зарплаты:");
        printEmployees(employees);
        System.out.println("\t Повысили зарплаты на 10%");
        indexSalary(employees, 10);
        printEmployees(employees);
        System.out.println();

        System.out.printf("Сотрудник с минимальной зарплатой по отделу \"1\" %s %n",
                findEmployeeWithMinSalarybyDepartment(employees, "1"));
        System.out.println();

        System.out.printf("Сотрудник с максимальной зарплатой по отделу \"1\" %s %n",
                findEmployeeWithMaxSalarybyDepartment(employees, "1"));
        System.out.println();

        System.out.printf("Сумма затрат на зарплату по отделу \"1\" %d %n",
                calculateSalarySum(findEmployeesByDepartment(employees, "1")));
        System.out.println();

        System.out.printf("Средняя зарплата по отделу \"1\" %.0f %n",
                findAverageSalaryByDepartment(employees, "1"));
        System.out.println();

        printEmployees(findEmployeesByDepartment(employees, "2"));
        System.out.println("Индексируем зарплату сотрудников отдела \"2\" на 100%");
        indexSalary(findEmployeesByDepartment(employees, "2"), 100);
        printEmployees(findEmployeesByDepartment(employees, "2"));
        System.out.println();

        System.out.println("Список всех сотрудников отдела \"2\"");
        printEmployeesNames(findEmployeesByDepartment(employees, "2"));
        System.out.println();

        System.out.println("Все сотрудники с зарплатой меньше 20_000:");
        findEmpoyeesWithSalaryLowerThan(employees, 20000);
        System.out.println();

        System.out.println("Все сотрудники с зарплатой ,больше 13_000:");
        findEmpoyeesWithSalaryBiggerThan(employees, 13000);
        System.out.println();
    }

    private static void findEmpoyeesWithSalaryBiggerThan(Employee[] employees, int number) {
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() > number) {
                System.out.println(employees[i]);
                count++;
            }
        }
        if (count == 0) {
            System.out.printf("Сотрудников с зарплатой больше %d нет %n", number);
        }
    }

    private static void findEmpoyeesWithSalaryLowerThan(Employee[] employees, int number) {
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() < number) {
                System.out.println(employees[i]);
                count++;
            }
        }
        if (count == 0) {
            System.out.printf("Сотрудников с зарплатой меньше %d нет %n", number);
        }
    }

    private static void printEmployeesNames(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            System.out.printf("%s %s %s %n", employees[i].getLastName(), employees[i].getFirstName(),
                    employees[i].getMiddleName());
        }
    }

    private static double findAverageSalaryByDepartment(Employee[] employees, String department) {
        double averageSalaryByDepartment = findAverageSalary(findEmployeesByDepartment(employees, department));
        return averageSalaryByDepartment;
    }

    private static Employee[] findEmployeesByDepartment(Employee[] employees, String department) {
        Employee[] byDepartment = new Employee[employees.length];
        int j = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getDepartment() == department) {
                byDepartment[j++] = employees[i];
            }
        }
        return byDepartment;
    }

    private static Object findEmployeeWithMinSalarybyDepartment(Employee[] employees, String department) {
        Employee[] employeesByDepartment = findEmployeesByDepartment(employees, department);
        return findEmployeeWithMinSalary(employeesByDepartment);
    }

    private static Object findEmployeeWithMaxSalarybyDepartment(Employee[] employees, String department) {
        Employee[] employeesByDepartment = findEmployeesByDepartment(employees, department);
        return findEmployeeWithMaxSalary(employeesByDepartment);
    }

    public static void printEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
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

    public static Object findEmployeeWithMinSalary(Employee[] employees) {
        int minSalary = employees[0].getSalary();
        Employee employeeWithMinSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() <= minSalary) {
                minSalary = employees[i].getSalary();
                employeeWithMinSalary = employees[i];
            }
        }
        return employeeWithMinSalary;
    }

    public static Object findEmployeeWithMaxSalary(Employee[] employees) {
        int maxSalary = employees[0].getSalary();
        Employee employeeWithMaxSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() >= maxSalary) {
                maxSalary = employees[i].getSalary();
                employeeWithMaxSalary = employees[i];
            }
        }
        return employeeWithMaxSalary;
    }

    public static double findAverageSalary(Employee[] employees) {
        double averageSalary = Math.round(((double) calculateSalarySum(employees) / findEmployeeCount(employees)) * 100.0) / 100.0;
        return averageSalary;
    }

    private static int findEmployeeCount(Employee[] employees) {
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                counter++;
            }
        }
        return counter;
    }

    public static void indexSalary(Employee[] employees, double percent) {
        percent = Math.round(percent / 100.0 * 100.0) / 100.0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            employees[i].setSalary(
                    (int) (employees[i].getSalary() + employees[i].getSalary() * percent));
        }
    }
}