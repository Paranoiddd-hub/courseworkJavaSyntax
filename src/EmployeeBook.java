import java.util.Arrays;

public class EmployeeBook {
    private Employee[] employees = new Employee[10];

    public Employee[] getEmployees() {
        return employees;
    }

    public boolean addNewEmployee(Employee[] employees, Employee newEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                return true;
            }
        }
        return false;
    }

    public boolean removeEmployee(Employee[] employees, int id) {
        int employeeIndex = findEmployeeIndexByID(employees, id);
        for (int i = 0; i < employees.length; i++) {
            if (employeeIndex >= 0) {
                employees[employeeIndex] = null;
                return true;
            }
        }
        return false;
    }

    public int findEmployeeIndexByID(Employee[] employees, int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void findEmpoyeesWithSalaryBiggerThan(Employee[] employees, int number) {
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

    public void findEmpoyeesWithSalaryLowerThan(Employee[] employees, int number) {
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

    public void printEmployeesNames(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            System.out.printf("%s %s %s %n", employees[i].getLastName(), employees[i].getFirstName(),
                    employees[i].getMiddleName());
        }
    }

    public double findAverageSalaryByDepartment(Employee[] employees, String department) {
        double averageSalaryByDepartment = findAverageSalary(findEmployeesByDepartment(employees, department));
        return averageSalaryByDepartment;
    }

    public Employee[] findEmployeesByDepartment(Employee[] employees, String department) {
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

    public Object findEmployeeWithMinSalarybyDepartment(Employee[] employees, String department) {
        Employee[] employeesByDepartment = findEmployeesByDepartment(employees, department);
        return findEmployeeWithMinSalary(employeesByDepartment);
    }

    public Object findEmployeeWithMaxSalarybyDepartment(Employee[] employees, String department) {
        Employee[] employeesByDepartment = findEmployeesByDepartment(employees, department);
        return findEmployeeWithMaxSalary(employeesByDepartment);
    }

    public void printEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            System.out.println(employees[i]);
        }
    }

    public int calculateSalarySum(Employee[] employees) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            sum += employees[i].getSalary();
        }
        return sum;
    }

    public Object findEmployeeWithMinSalary(Employee[] employees) {
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

    public Object findEmployeeWithMaxSalary(Employee[] employees) {
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

    public double findAverageSalary(Employee[] employees) {
        double averageSalary = Math.round(((double) calculateSalarySum(employees) / findEmployeeCount(employees)) * 100.0) / 100.0;
        return averageSalary;
    }

    public int findEmployeeCount(Employee[] employees) {
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                counter++;
            }
        }
        return counter;
    }

    public void indexSalary(Employee[] employees, double percent) {
        percent = Math.round(percent / 100.0 * 100.0) / 100.0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            employees[i].setSalary(
                    (int) (employees[i].getSalary() + employees[i].getSalary() * percent));
        }
    }

    public Object findEmployeeByID(Employee[] employees, int id) {
        int employeeIndex = findEmployeeIndexByID(employees, id);
        if (employeeIndex > 0) {
            return employees[employeeIndex];
        }
        return "Такого сотрудника нет";
    }
}
