class Vehicle {
    protected String vehicleName;
    protected double rentPerDay;

    public Vehicle(String vehicleName, double rentPerDay) {
        this.vehicleName = vehicleName;
        this.rentPerDay = rentPerDay;
    }

    public void displayDetails() {
        System.out.println("Vehicle: " + vehicleName);
        System.out.println("Rent Per Day: ₹" + rentPerDay);
    }
}

// Inheritance
class Car extends Vehicle {
    private int seats;

    public Car(String vehicleName, double rentPerDay, int seats) {
        super(vehicleName, rentPerDay);
        this.seats = seats;
    }

    // Method Overriding
    @Override
    public void displayDetails() {
        System.out.println("Car: " + vehicleName);
        System.out.println("Rent Per Day: ₹" + rentPerDay);
        System.out.println("Seats: " + seats);
    }
}

// Another child class
class Bike extends Vehicle {
    private boolean helmetIncluded;

    public Bike(String vehicleName, double rentPerDay, boolean helmetIncluded) {
        super(vehicleName, rentPerDay);
        this.helmetIncluded = helmetIncluded;
    }

    // Method Overriding
    @Override
    public void displayDetails() {
        System.out.println("Bike: " + vehicleName);
        System.out.println("Rent Per Day: ₹" + rentPerDay);
        System.out.println("Helmet Included: " + helmetIncluded);
    }
}

// Composition
class RentalService {
    private Vehicle[] vehicles;

    public RentalService(Vehicle[] vehicles) {
        this.vehicles = vehicles;
    }

    // Polymorphism
    public void showVehicles() {
        System.out.println("Available Vehicles:");
        for (Vehicle v : vehicles) {
            v.displayDetails();   // runtime polymorphism
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Car("Swift", 2000, 5);
        Vehicle v2 = new Bike("Royal Enfield", 800, true);

        Vehicle[] list = {v1, v2};

        RentalService service = new RentalService(list);
        service.showVehicles();
    }
}s