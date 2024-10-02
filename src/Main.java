public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.getEmployees()[0] = new Employee("Иванов", "Иван", "Иванович",
                10_000, "1");
        employeeBook.getEmployees()[1] = new Employee("Петров", "Петр", "Петрович",
                11_000, "1");
        employeeBook.getEmployees()[2] = new Employee("Сидоров", "Сидор", "Сидорович",
                12_000, "1");
        employeeBook.getEmployees()[3] = new Employee("Мажоров", "Мажор", "Мажорович",
                150_000, "2");

        employeeBook.printEmployees(employeeBook.getEmployees());
        System.out.println();

        System.out.printf("Рассходы на заработную плату сотрудников составляют %d рублей %n",
                employeeBook.calculateSalarySum(employeeBook.getEmployees()));
        System.out.println();

        System.out.printf("Сотрудник с минимальной зарплатой:%n %s%n", employeeBook.findEmployeeWithMinSalary(employeeBook.getEmployees()));
        System.out.println();

        System.out.printf("Сотрудник с максимальной зарплатой:%n %s%n", employeeBook.findEmployeeWithMaxSalary(employeeBook.getEmployees()));
        System.out.println();

        System.out.printf("Средняя зарплата составляет %.0f %n", employeeBook.findAverageSalary(employeeBook.getEmployees()));
        System.out.println();

        System.out.println("Список ФИО всех сотрудников:");
        employeeBook.printEmployeesNames(employeeBook.getEmployees());
        System.out.println();



        // Повышенная сложность
        System.out.println("\t Повышенная сложность");

        System.out.println("\t Текущие зарплаты:");
        employeeBook.printEmployees(employeeBook.getEmployees());
        System.out.println("\t Повысили зарплаты на 10%");
        employeeBook.indexSalary(employeeBook.getEmployees(), 10);
        employeeBook.printEmployees(employeeBook.getEmployees());
        System.out.println();

        System.out.printf("Сотрудник с минимальной зарплатой по отделу \"1\" %s %n",
                employeeBook.findEmployeeWithMinSalarybyDepartment(employeeBook.getEmployees(), "1"));
        System.out.println();

        System.out.printf("Сотрудник с максимальной зарплатой по отделу \"1\" %s %n",
                employeeBook.findEmployeeWithMaxSalarybyDepartment(employeeBook.getEmployees(), "1"));
        System.out.println();

        System.out.printf("Сумма затрат на зарплату по отделу \"1\" %d %n",
                employeeBook.calculateSalarySum(employeeBook.findEmployeesByDepartment(employeeBook.getEmployees(), "1")));
        System.out.println();

        System.out.printf("Средняя зарплата по отделу \"1\" %.0f %n",
                employeeBook.findAverageSalaryByDepartment(employeeBook.getEmployees(), "1"));
        System.out.println();

        employeeBook.printEmployees(employeeBook.findEmployeesByDepartment(employeeBook.getEmployees(), "2"));
        System.out.println("Индексируем зарплату сотрудников отдела \"2\" на 100%");
        employeeBook.indexSalary(employeeBook.findEmployeesByDepartment(employeeBook.getEmployees(), "2"), 100);
        employeeBook.printEmployees(employeeBook.findEmployeesByDepartment(employeeBook.getEmployees(), "2"));
        System.out.println();

        System.out.println("Список всех сотрудников отдела \"2\"");
        employeeBook.printEmployeesNames(employeeBook.findEmployeesByDepartment(employeeBook.getEmployees(), "2"));
        System.out.println();

        System.out.println("Все сотрудники с зарплатой меньше 20_000:");
        employeeBook.findEmpoyeesWithSalaryLowerThan(employeeBook.getEmployees(), 20000);
        System.out.println();

        System.out.println("Все сотрудники с зарплатой ,больше 13_000:");
        employeeBook.findEmpoyeesWithSalaryBiggerThan(employeeBook.getEmployees(), 13000);
        System.out.println();



        // Очень сложно
        System.out.println("Текущие сотрудники:");
        employeeBook.printEmployees(employeeBook.getEmployees());
        System.out.println("Добавляем нового сотрудника Новичкова");
        Employee newEmployee = new Employee("Новичков", "Новичок", "Новичковович", 10, "2");
        System.out.println(employeeBook.addNewEmployee(employeeBook.getEmployees(), newEmployee));
        employeeBook.printEmployees(employeeBook.getEmployees());

        System.out.println("Удаляем сотрудника Иванова под id 1");
        System.out.println(employeeBook.removeEmployee(employeeBook.getEmployees(), 1));
        employeeBook.printEmployees(employeeBook.getEmployees());
        System.out.println();

        System.out.println("Ищем сотрудника по id 2");
        System.out.println(employeeBook.findEmployeeByID(employeeBook.getEmployees(), 2));
    }
}