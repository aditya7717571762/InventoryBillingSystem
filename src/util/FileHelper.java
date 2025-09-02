package util;

import model.Product;
import java.io.*;
import java.util.*;

public class FileHelper {
    private static final String FILE_NAME = "inventory.txt";

    public static void saveInventory(Map<Integer, Product> inventory) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Product p : inventory.values()) {
                writer.write(p.getId() + "," + p.getName() + "," + p.getQuantity() + "," + p.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Integer, Product> loadInventory() {
        Map<Integer, Product> inventory = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int qty = Integer.parseInt(parts[2]);
                    double price = Double.parseDouble(parts[3]);
                    inventory.put(id, new Product(id, name, qty, price));
                }
            }
        } catch (IOException e) {
            System.out.println("No inventory file found, starting fresh...");
        }
        return inventory;
    }
}
