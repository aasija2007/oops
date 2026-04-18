import java.util.*;

// Custom Exception
class SeatNotAvailableException extends Exception {
    public SeatNotAvailableException(String message) {
        super(message);
    }
}

// Show class
class Show {
    String movieName;
    int totalSeats;

    Show(String movieName, int totalSeats) {
        this.movieName = movieName;
        this.totalSeats = totalSeats;
    }
}

// Customer class
class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

// Main class
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Show show = new Show("Avengers", 5);

        System.out.println("Movie Show: " + show.movieName);
        System.out.println("Available Seats: " + show.totalSeats);

        try {
            System.out.print("Enter customer name: ");
            String cname = sc.nextLine();
            Customer customer = new Customer(cname);

            System.out.print("Enter seat number to book: ");
            int seat = sc.nextInt();

            if (seat <= 0 || seat > show.totalSeats) {
                throw new SeatNotAvailableException("Seat not available for booking.");
            }

            System.out.println("\nBooking Successful!");
            System.out.println("Customer: " + customer.name);
            System.out.println("Movie: " + show.movieName);
            System.out.println("Seat Number: " + seat);

        } catch (SeatNotAvailableException e) {
            System.out.println("Custom Exception: " + e.getMessage());

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid seat number.");

        } finally {
            System.out.println("End of Ticket Booking Process.");
            sc.close();
        }
    }
}