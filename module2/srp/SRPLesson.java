package module2.srp;

/**
 * MODULE 2.1: Single Responsibility Principle (SRP)
 * 
 * --- THE CHALLENGE ---
 * We want to create an Invoice system.
 * A "Bad" implementation would have a single `Invoice` class that:
 * 1.  Calculates the total amount.
 * 2.  Saves the invoice to a database.
 * 3.  Prints the invoice as PDF.
 */

// --- THE BAD WAY: THE "GOD CLASS" ---
class InvoiceBad {
    private String bookName;
    private int quantity;
    private double pricePerUnit;

    public InvoiceBad(String bookName, int quantity, double pricePerUnit) {
        this.bookName = bookName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    // Responsibility 1: Calculation
    public double calculateTotal() {
        return pricePerUnit * quantity;
    }

    // Responsibility 2: Persistence (Database Logic)
    public void saveToDatabase() {
        System.out.println("Saving invoice for " + bookName + " to MySQL Database...");
    }

    // Responsibility 3: Presentation (Printing Logic)
    public void printInvoice() {
        System.out.println("Printing Invoice for " + bookName + ": ₹" + calculateTotal());
    }
}

// --- THE GOOD WAY: SRP COMPLIANT ---
// Notice how each class has only ONE reason to change.

class Invoice {
    private String bookName;
    private int quantity;
    private double pricePerUnit;

    public Invoice(String bookName, int quantity, double pricePerUnit) {
        this.bookName = bookName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public String getBookName() { return bookName; }
    public int getQuantity() { return quantity; }
    public double getPricePerUnit() { return pricePerUnit; }

    // ONLY Responsibility: Calculation
    public double calculateTotal() {
        return pricePerUnit * quantity;
    }
}

class InvoiceRepository {
    // ONLY Responsibility: Persistence
    public void save(Invoice invoice) {
        System.out.println("Saving invoice for " + invoice.getBookName() + " to Database...");
    }
}

class InvoicePrinter {
    // ONLY Responsibility: Presentation
    public void print(Invoice invoice) {
        System.out.println("Printing Invoice for " + invoice.getBookName() + ": ₹" + invoice.calculateTotal());
    }
}

public class SRPLesson {
    public static void main(String[] args) {
        System.out.println("--- SRP Example ---");

        // Using SRP Classes
        Invoice myInvoice = new Invoice("Clean Code", 1, 500.0);
        
        InvoiceRepository repository = new InvoiceRepository();
        repository.save(myInvoice);

        InvoicePrinter printer = new InvoicePrinter();
        printer.print(myInvoice);
        
        System.out.println("\nNotice how if you want to switch from a Database to a JSON file,");
        System.out.println("you ONLY change the 'InvoiceRepository' class. You don't touch the others.");
    }
}
