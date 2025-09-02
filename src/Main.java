import model.Product;
import service.InventoryManager;
import service.BillingManager;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        InventoryManager inv = new InventoryManager();
        BillingManager bill = new BillingManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Inventory Billing System ===");
        System.out.println("Current Inventory:");
        inv.showInventory();

        List<Product> cart = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add Product to Inventory");
            System.out.println("2. Purchase Product");
            System.out.println("3. Show Inventory");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    inv.addProduct(new Product(id, name, qty, price));
                    inv.save();
                    System.out.println("Product added!");
                    break;

                case 2:
                    System.out.print("Enter Product ID to purchase: ");
                    int pid = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int pq = sc.nextInt();

                    Product p = inv.getProduct(pid);
                    if (p != null && p.getQuantity() >= pq) {
                        cart.add(new Product(p.getId(), p.getName(), pq, p.getPrice()));
                        inv.updateStock(pid, -pq);
                        inv.save();
                        System.out.println("Added to cart!");
                    } else {
                        System.out.println("Invalid product or insufficient stock!");
                    }
                    break;

                case 3:
                    inv.showInventory();
                    break;

                case 4:
                    if (!cart.isEmpty()) {
                        bill.generateBill(cart);
                    }
                    inv.save();
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
