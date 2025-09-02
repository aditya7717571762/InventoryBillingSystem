package service;

import model.Product;
import util.FileHelper;
import java.util.*;

public class InventoryManager {
    private Map<Integer, Product> inventory;

    public InventoryManager() {
        inventory = FileHelper.loadInventory();
    }

    public void addProduct(Product p) {
        inventory.put(p.getId(), p);
    }

    public void updateStock(int id, int quantity) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.setQuantity(p.getQuantity() + quantity);
        }
    }

    public void showInventory() {
        System.out.println("ID | Name | Quantity | Price");
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }

    public Product getProduct(int id) {
        return inventory.get(id);
    }

    public void save() {
        FileHelper.saveInventory(inventory);
    }
}
