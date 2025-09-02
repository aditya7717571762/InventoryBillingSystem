package service;

import model.Product;
import java.util.*;

public class BillingManager {
    public double generateBill(List<Product> items) {
        double total = 0;
        System.out.println("\n--- Bill ---");
        for (Product p : items) {
            double lineTotal = p.getPrice() * p.getQuantity();
            System.out.println(p.getName() + " x" + p.getQuantity() + " = $" + lineTotal);
            total += lineTotal;
        }
        System.out.println("Total: $" + total);
        return total;
    }
}
