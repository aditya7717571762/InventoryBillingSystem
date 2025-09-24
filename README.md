# Inventory Billing System (Java, OOP, File Handling)

##  Features
- Add, update, and manage products in inventory
- Generate customer bills
- Persistent storage using **File Handling (CSV/Text)**

##  Tech Stack
- **Language:** Java (JDK 8+)
- **Persistence:** File Handling (`inventory.txt`)
- **IDE:** VS Code (or any Java IDE)

##  Project Structure
```
InventoryBillingSystem/
 ┣ src/
 ┃ ┣ Main.java
 ┃ ┣ model/Product.java
 ┃ ┣ service/InventoryManager.java
 ┃ ┣ service/BillingManager.java
 ┃ ┗ util/FileHelper.java
 ┣ inventory.txt (auto-created)
 ┗ README.md
```

##  Run Instructions
1. Open the folder in **VS Code / IntelliJ**
2. open terminal
3. write the code (javac Main.java)
4. and then (java main.java)

##  Example Flow
1. Add Product → Stored in `inventory.txt`
2. Purchase Product → Stock decreases
3. Generate Bill → Shows total amount
4. Restart program → Inventory persists

---
