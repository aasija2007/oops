import java.util.*;
class Item {
 String name;
 double price;
 int quantity;
 Item(String name, double price, int quantity) {
 this.name = name;
 this.price = price;
 this.quantity = quantity;
 }
 double total() {
 return price * quantity;
 }
}
public class Solution {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 // Collection with Generics
 ArrayList<Item> items = new ArrayList<Item>();
 System.out.print("Enter number of items: ");
 int n = sc.nextInt();
 sc.nextLine();
 for (int i = 0; i < n; i++) {
 System.out.print("Enter item name: ");
 String name = sc.nextLine();
 System.out.print("Enter price: ");
 double price = sc.nextDouble();
 System.out.print("Enter quantity: ");
 int qty = sc.nextInt();
 sc.nextLine();
 items.add(new Item(name, price, qty));
 }
 double totalBill = 0;
 System.out.println("\n----- BILL -----");
 for (Item i : items) {
 double itemTotal = i.total();
 System.out.println(i.name + " " + i.quantity + " x " + i.price + " = " + itemTotal);
 totalBill += itemTotal;
 }
 System.out.println("Total Bill: " + totalBill);
 sc.close();
 }
}