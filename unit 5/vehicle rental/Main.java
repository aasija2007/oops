// Vehicle interface
interface Vehicle {
    void rent();
}

// Car class
class Car implements Vehicle {
    public void rent() {
        System.out.println("Car rented for customer.");
    }
}

// Bike class
class Bike implements Vehicle {
    public void rent() {
        System.out.println("Bike rented for customer.");
    }
}

// Truck class
class Truck implements Vehicle {
    public void rent() {
        System.out.println("Truck rented for customer.");
    }
}

// Factory class
class VehicleFactory {
    public Vehicle getVehicle(String type) {
        if (type == null) return null;

        if (type.equalsIgnoreCase("car")) {
            return new Car();
        } 
        else if (type.equalsIgnoreCase("bike")) {
            return new Bike();
        } 
        else if (type.equalsIgnoreCase("truck")) {
            return new Truck();
        }

        return null;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();

        Vehicle v1 = factory.getVehicle("car");
        v1.rent();

        Vehicle v2 = factory.getVehicle("bike");
        v2.rent();

        Vehicle v3 = factory.getVehicle("truck");
        v3.rent();
    }
}