
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Menu");
        System.out.println("1. Car Details");
        System.out.println("2. Bike Details");

        int choice = sc.nextInt();
        sc.nextLine();

        Vehicle v;   

        if (choice == 1) {
            System.out.println("Enter brand:");
            String brand = sc.nextLine();

            System.out.println("Enter model:");
            String model = sc.nextLine();

            System.out.println("Enter number of doors:");
            int doors = sc.nextInt();

            v = new Car(brand, model, doors);   
        } 
        else {
            System.out.println("Enter brand:");
            String brand = sc.nextLine();

            System.out.println("Enter model:");
            String model = sc.nextLine();

            System.out.println("Does it have gear? (true/false):");
            boolean gear = sc.nextBoolean();

            v = new Bike(brand, model, gear);  
        }

        System.out.println("\nVehicle Details:");
        v.displayDetails();   

        
    }
}
class Vehicle {
    String brand;
    String model;

    Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    void displayDetails() {
        System.out.println("Vehicle Brand: " + brand);
        System.out.println("Vehicle Model: " + model);
    }
}

class Car extends Vehicle {
    int numberOfDoors;

    Car(String brand, String model, int numberOfDoors) {
        super(brand, model);
        this.numberOfDoors = numberOfDoors;
    }

    
    void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Type: Car");
    }
}

class Bike extends Vehicle {
    boolean hasGear;

    Bike(String brand, String model, boolean hasGear) {
        super(brand, model);
        this.hasGear = hasGear;
    }

    
    void displayDetails() {
        super.displayDetails();
        System.out.println("Has Gear: " + hasGear);
        System.out.println("Type: Bike");
    }
}

