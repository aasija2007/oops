import java.util.*;

// Inventory class
class Inventory {
    HashMap<String, Integer> stock = new HashMap<>();

    void addProduct(String name, int quantity) {
        if (quantity < 0) {
            System.out.println("Quantity cannot be negative.");
            return;
        }

        stock.put(name, quantity);
        System.out.println(name + " added with quantity " + quantity);
    }

    void updateStock(String name, int quantity) {
        if (!stock.containsKey(name)) {
            System.out.println("Product not found.");
            return;
        }

        int newQuantity = stock.get(name) + quantity;

        if (newQuantity < 0) {
            System.out.println("Stock cannot become negative.");
            return;
        }

        stock.put(name, newQuantity);
        System.out.println("Stock updated for " + name);
    }

    void displayStock() {
        System.out.println("\nInventory Stock:");
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

// Main class
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inv = new Inventory();

        try {
            System.out.print("Enter product name: ");
            String product = sc.nextLine();

            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();

            inv.addProduct(product, qty);

            System.out.print("Enter quantity to update: ");
            int update = sc.nextInt();

            inv.updateStock(product, update);
            inv.displayStock();

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numbers only.");

        } finally {
            sc.close();
        }
    }
}