package abstraction;

// 1. Interface: Defines a 'contract' or capability
interface PaymentProcessor {
    // Abstract method: What it does, without showing how.
    void processPayment(double amount);
}

// 2. Concrete Implementation A
class PaypalProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Connecting to PayPal API...");
        System.out.println("Successfully processed $" + amount + " via PayPal.");
    }
}

// 3. Concrete Implementation B
class StripeProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing secure tokens via Stripe...");
        System.out.println("Successfully processed $" + amount + " via Stripe.");
    }
}

// 4. Abstract Class: Shared behavior + state
abstract class CheckoutSystem {
    protected String userEmail; // Shared state
    
    public CheckoutSystem(String userEmail) {
        this.userEmail = userEmail;
    }
    
    // Abstract method (forces child to implement)
    abstract void sendReceipt(); 
    
    // Concrete method (shared behavior)
    public void executeCheckout(PaymentProcessor processor, double amount) {
        System.out.println("Starting checkout for " + userEmail);
        
        // **MAGIC OF ABSTRACTION** 
        // We don't care if it's Stripe or PayPal. We just know it can 'processPayment'.
        processor.processPayment(amount); 
        
        sendReceipt();
    }
}

// 5. Concrete Subclass of Abstract Class
class PremiumCheckout extends CheckoutSystem {
    public PremiumCheckout(String email) {
        super(email);
    }

    @Override
    void sendReceipt() {
        System.out.println("Sending premium receipt + 10% discount coupon to " + userEmail);
    }
}

public class AbstractionLesson {
    public static void main(String[] args) {
        System.out.println("--- Abstraction Demo ---");
        
        CheckoutSystem checkout = new PremiumCheckout("john@example.com");
        
        // We can plug and play different implementations effortlessly!
        PaymentProcessor currentGateway = new StripeProcessor(); 
        
        checkout.executeCheckout(currentGateway, 99.99);
    }
}
