import java.util.*;

class Employee {
    private String name;
    private Long salary;

    public Employee(String name, Long salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-20d", name, salary);
    }
}

class EmployeeBO {
    public void displayAllEmployeeDetails(Employee[] empList) {
        System.out.println("\nEmployee Details");
        System.out.printf("%-20s %-20s\n", "Name", "Salary");
        for (Employee e : empList) {
            System.out.println(e);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee[] emp = new Employee[2];

        System.out.println("Enter the values for Employee 1");
        System.out.println("Enter the Name");
        String name1 = sc.nextLine();

        System.out.println("Enter the Salary");
        Long sal1 = sc.nextLong();
        sc.nextLine(); // consume newline

        emp[0] = new Employee(name1, sal1);

        System.out.println("\nEnter the values for Employee 2");
        System.out.println("Enter the Name");
        String name2 = sc.nextLine();

        System.out.println("Enter the Salary");
        Long sal2 = sc.nextLong();

        emp[1] = new Employee(name2, sal2);

        EmployeeBO bo = new EmployeeBO();
        bo.displayAllEmployeeDetails(emp);

        sc.close();
    }
}