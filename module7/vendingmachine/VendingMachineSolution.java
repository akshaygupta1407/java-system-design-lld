package module7.vendingmachine;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * PRACTICE SOLUTION AREA: Vending Machine
 *
 * Read VendingMachineQuestion.md first.
 *
 * Solve the problem here. Start with:
 * 1. Product
 * 2. Inventory
 * 3. VendingMachine
 * 4. Transaction flow
 *
 * Keep the first version simple. We can improve it together after review.
 */

class Product {
    private final String name;
    private final BigDecimal price;

    Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public BigDecimal getPriceOfProduct() {
        return this.price;
    }

    public String getNameOfProduct() {
        return this.name;
    }
}

class InventoryItem {
    private final Product product;
    private int quantity;
    
    InventoryItem(Product product, Integer qty) {
        this.product = product;
        this.quantity = qty;
    }

    public void addItems(int quantity) {
        this.quantity += quantity;
        System.out.println("Items added Successfully");
    }

    public void removeItems(int quantity) {
        if(this.quantity >= quantity)
            this.quantity -= quantity;
        else 
            System.out.println("Quantity is not enough to remove");
    }

    public int getProductQty() {
       return quantity;
    }

    public String getProductName() {
        return product.getNameOfProduct();
    }

    public BigDecimal getPrice() {
        return product.getPriceOfProduct();
    }
}

class Inventory {
    private final Map<String, InventoryItem> inventories;
    
    Inventory() {
        inventories = new HashMap<>();
    }

    public void addInventories(String code, InventoryItem inventoryItem) {
        if(inventories.containsKey(code)) {
            InventoryItem existInventory = inventories.get(code);
            existInventory.addItems(inventoryItem.getProductQty());
        } else {
            inventories.put(code, inventoryItem);
        }
    }

    public Map<String, InventoryItem> getInventories() {
        return this.inventories;
    }

    public boolean containsProduct(String code) {
        return inventories.containsKey(code);
    }

    public int getProductQty(String code) {
        if(inventories.containsKey(code)) {
            return inventories.get(code).getProductQty();
        }
        return 0;
    }

    public BigDecimal getTotalAmount(String code, int quantity) {
        if(inventories.containsKey(code) && getProductQty(code) >= quantity) {
            return inventories.get(code).getPrice().multiply(BigDecimal.valueOf(quantity));
        }
        return BigDecimal.valueOf(0);
    }

    public void reduceStock(String code, int quantity) {
        InventoryItem inventory = inventories.get(code);
        inventory.removeItems(quantity);
    }

}

class Transaction {
    
    public boolean isPaymentEnough(BigDecimal amount, BigDecimal money) {
        if(amount.compareTo(money) > 0) {
            System.out.println("Insufficient money. Returning money: " + money);
            return false;
        }
        System.out.println("Transaction successfull");
        return true;
    }

    public BigDecimal calculateChange(BigDecimal amount, BigDecimal money) {
        return money.subtract(amount);
    }

    public void returnChange(BigDecimal change) {
        if(change.compareTo(BigDecimal.valueOf(0)) > 0) {
            System.out.println("Returning change: " + change);
        }
    }

}

class VendingMachine {
        private final Inventory inventory;
        private final Transaction transaction;
    
        VendingMachine() {
            inventory = new Inventory();
            transaction = new Transaction();
        }

        public void addProductToInventory(String code, InventoryItem inventoryItem) {
            inventory.addInventories(code, inventoryItem);
        }

        public void purchaseProduct(String code, int quantity, BigDecimal money) {
            if(!inventory.containsProduct(code)) {
                System.out.println("Invalid code selected");
                return;
            }

            if(quantity <= 0) {
                System.out.println("Invalid quantity selected");
                return;
            }

            if(quantity > inventory.getProductQty(code)) {
                System.out.println("Selected quantity is not available");
                return;
            }

            BigDecimal amount = inventory.getTotalAmount(code, quantity);
            System.out.println("Amount of product is: " + amount);

            if(!transaction.isPaymentEnough(amount, money)) {
                System.out.println("Transaction Failed");
                return;
            }

            BigDecimal change = transaction.calculateChange(amount, money);
            transaction.returnChange(change);
            inventory.reduceStock(code, quantity);
            System.out.println("Dispensing your product...");
        }

        public boolean isValidProductCode(String code) {
            return inventory.containsProduct(code);
        }

        public boolean isValidQuantity(String code, int quantity) {
            return quantity > 0 && quantity <= inventory.getProductQty(code);
        }

        public BigDecimal getTotalAmount(String code, int quantity) {
            return inventory.getTotalAmount(code, quantity);
        }

        public void showProducts() {
            Map<String, InventoryItem> inventories = inventory.getInventories();
            for(String key : inventories.keySet()) {
                System.out.println("Code: " + key + " Product Name: " + inventories.get(key).getProductName() + " Quantity: " + inventories.get(key).getProductQty() + " Price: " + inventories.get(key).getPrice());
            }
        }

        public void showProductDetails(String code) {
            Map<String, InventoryItem> inventories = inventory.getInventories();
            if(inventories.containsKey(code)) {
                InventoryItem inventoryItem = inventories.get(code);
                System.out.println("Code: " + code + " Product Name: " + inventoryItem.getProductName() + " Quantity: " + inventoryItem.getProductQty() + " Price: " + inventoryItem.getPrice());
            } else {
                System.out.println("Invalid code selected");
            }
        }
}

public class VendingMachineSolution {
    public static void main(String[] args) {
        System.out.println("--- Vending Machine Solution ---");

        // TODO:
        // 1. Add products to inventory.
        // 2. Select a product.
        // 3. Insert money.
        // 4. Dispense product.
        // 5. Return change.
        // 6. Try edge cases.

        VendingMachine vendingMachine = new VendingMachine();

        Scanner sc = new Scanner(System.in);
        Product product1 = new Product("Lays", BigDecimal.valueOf(10));
        Product product2 = new Product("Kurkure", BigDecimal.valueOf(20));
        Product product3 = new Product("Pepsi", BigDecimal.valueOf(40));
        Product product4 = new Product("Kitkat", BigDecimal.valueOf(25));

        InventoryItem inventoryItem1 = new InventoryItem(product1, 10);
        InventoryItem inventoryItem2 = new InventoryItem(product2, 12);
        InventoryItem inventoryItem3 = new InventoryItem(product3, 14);
        InventoryItem inventoryItem4 = new InventoryItem(product4, 8);

        vendingMachine.addProductToInventory("A1", inventoryItem1);
        vendingMachine.addProductToInventory("A2", inventoryItem2);
        vendingMachine.addProductToInventory("A3", inventoryItem3);
        vendingMachine.addProductToInventory("A4", inventoryItem4);

        boolean wantToProceed = true;

        while(wantToProceed) {
            System.out.println("Select your product");
            vendingMachine.showProducts();

            System.out.println("Select code and quantity...");
            String code = sc.nextLine();
            if(!vendingMachine.isValidProductCode(code)) {
                System.out.println("Invalid code selected");
                continue;
            }
            int quantity = sc.nextInt();
            sc.nextLine();
            if(!vendingMachine.isValidQuantity(code, quantity)) {
                System.out.println("Selected quantity is not available");
                continue;
            }
            BigDecimal getAmount = vendingMachine.getTotalAmount(code, quantity);
            System.out.println("Amount of product is: " + getAmount);

            System.out.println("Want to proceed??");
            wantToProceed = sc.nextBoolean();
            sc.nextLine();
            if(!wantToProceed) {
                System.out.println("Cancelling Transaction");
                break;
            }
            System.out.println("Please insert money");
            BigDecimal money = sc.nextBigDecimal();
            sc.nextLine();
            vendingMachine.purchaseProduct(code, quantity, money);

            System.out.println("Want to shop more???");
            wantToProceed = sc.nextBoolean();
            sc.nextLine();
        }

        System.out.println("Thank you for using the vending machine.");
    }
}
