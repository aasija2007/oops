import java.util.Scanner;

// Strategy Interface
interface PaymentStrategy {
    void pay(int amount);
}

// UPI Payment
class UPIPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using UPI.");
    }
}

// Card Payment
class CardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using Card.");
    }
}

// Cash on Delivery
class CashOnDelivery implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using Cash on Delivery.");
    }
}

// Context Class
class FoodOrder {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        if (paymentStrategy == null) {
            System.out.println("Payment method not selected.");
            return;
        }
        paymentStrategy.pay(amount);
    }
}

// Main CLI App
public class Main {
    public static void main(String[] args) {

        // try-with-resources auto closes scanner
        try (Scanner sc = new Scanner(System.in)) {
            FoodOrder order = new FoodOrder();

            System.out.println("===== Food Delivery App =====");
            System.out.print("Enter food amount: ");
            int amount = sc.nextInt();

            System.out.println("Choose Payment Method:");
            System.out.println("1. UPI");
            System.out.println("2. Card");
            System.out.println("3. Cash on Delivery");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    order.setPaymentStrategy(new UPIPayment());
                    break;
                case 2:
                    order.setPaymentStrategy(new CardPayment());
                    break;
                case 3:
                    order.setPaymentStrategy(new CashOnDelivery());
                    break;
                default:
                    System.out.println("Invalid choice");
                    return;
            }

            order.checkout(amount);
        }
    }
}