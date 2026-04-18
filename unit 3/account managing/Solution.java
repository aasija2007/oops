import java.util.*;

// Main class
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter Account Holder Name:");
            String name = sc.nextLine();

            System.out.println("Enter Balance:");
            double balance = sc.nextDouble();
            sc.nextLine(); // clear buffer

            PremiumAccount pa = new PremiumAccount(name, balance);

            System.out.println("\n1. Apply Loan");
            System.out.println("2. Apply Insurance");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.println("Enter Loan Amount:");
                double loanAmount = sc.nextDouble();
                pa.applyLoan(loanAmount);

            } else if (choice == 2) {
                System.out.println("Enter Insurance Type:");
                String type = sc.nextLine();
                pa.applyInsurance(type);

            } else {
                System.out.println("Invalid choice.");
            }

            System.out.println("\nAccount Details:");
            pa.displayAccountDetails();

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter correct data type.");

        } finally {
            sc.close();
        }
    }
}

// Parent class
class Account {
    String accountHolder;
    double balance;

    Account(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

// Loan interface
interface Loan {
    void applyLoan(double amount);
}

// Insurance interface
interface Insurance {
    void applyInsurance(String type);
}

// Child class implementing multiple interfaces
class PremiumAccount extends Account implements Loan, Insurance {

    PremiumAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    public void applyLoan(double amount) {
        System.out.println("Loan Applied: ₹" + amount);
    }

    public void applyInsurance(String type) {
        System.out.println("Insurance Type Selected: " + type);
    }
}