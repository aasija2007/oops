import java.util.*;

interface IEmployeeDetails {
    void displayEmployeeDetails();
}

abstract class Employee implements IEmployeeDetails {
    protected String empName;
    protected int empId;
    protected double basicSalary;

    Employee(String empName, int empId, double basicSalary) {
        this.empName = empName;
        this.empId = empId;
        this.basicSalary = basicSalary;
    }

    public abstract void displayEmployeeDetails();
}

class FullTimeEmployee extends Employee {
    private double bonus;
    private double deductions;

    FullTimeEmployee(String empName, int empId, double basicSalary,
                     double bonus, double deductions) {
        super(empName, empId, basicSalary);
        this.bonus = bonus;
        this.deductions = deductions;
    }

    @Override
    public void displayEmployeeDetails() {
        double netSalary = basicSalary + bonus - deductions;

        System.out.println("\nEmployee Details:");
        System.out.println("Employee Name: " + empName);
        System.out.println("Employee ID: " + empId);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Deductions: " + deductions);
        System.out.println("Net Salary: " + netSalary);
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    PartTimeEmployee(String empName, int empId, double basicSalary,
                     int hoursWorked, double hourlyRate) {
        super(empName, empId, basicSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public void displayEmployeeDetails() {
        double totalSalary = hoursWorked * hourlyRate;

        System.out.println("\nEmployee Details:");
        System.out.println("Employee Name: " + empName);
        System.out.println("Employee ID: " + empId);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Total Salary: " + totalSalary);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Menu");
        System.out.println("1. Full Time Employee");
        System.out.println("2. Part Time Employee");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String empName = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        int empId = sc.nextInt();

        System.out.print("Enter Basic Salary: ");
        double basicSalary = sc.nextDouble();

        Employee e;

        if (choice == 1) {
            System.out.print("Enter Bonus: ");
            double bonus = sc.nextDouble();

            System.out.print("Enter Deductions: ");
            double deductions = sc.nextDouble();

            e = new FullTimeEmployee(empName, empId, basicSalary, bonus, deductions);
            e.displayEmployeeDetails();

        } else if (choice == 2) {
            System.out.print("Enter Hours Worked: ");
            int hoursWorked = sc.nextInt();

            System.out.print("Enter Hourly Rate: ");
            double hourlyRate = sc.nextDouble();

            e = new PartTimeEmployee(empName, empId, basicSalary, hoursWorked, hourlyRate);
            e.displayEmployeeDetails();

        } else {
            System.out.println("Invalid Choice");
        }

        sc.close();
    }
}