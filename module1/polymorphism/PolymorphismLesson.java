package polymorphism;

/**
 * MODULE 1.4: Polymorphism (Static vs Dynamic)
 * 
 * This file demonstrates the two types of polymorphism that are fundamental to 
 * building robust systems in Java.
 */

// --- 1. Static Polymorphism (Method Overloading) ---
class Calculator {
    // Both methods have the same name, but different signatures.
    // The compiler knows which one to call at compile-time based on arguments.
    
    public int sum(int a, int b) {
        System.out.println("Sum of two integers: " + (a + b));
        return a + b;
    }

    public int sum(int a, int b, int c) {
        System.out.println("Sum of three integers: " + (a + b + c));
        return a + b + c;
    }

    public double sum(double a, double b) {
        System.out.println("Sum of two doubles: " + (a + b));
        return a + b;
    }
}

// --- 2. Dynamic Polymorphism (Method Overriding) ---
// This is the core of "Plug and Play" architecture.

interface PaymentProcessor {
    void processPayment(double amount);
}

class NetBankingProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of ₹" + amount + " via Net Banking...");
    }
}

class UPIProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of ₹" + amount + " via UPI (PhonePe/GPay)...");
    }
}

public class PolymorphismLesson {
    public static void main(String[] args) {
        System.out.println("--- Static Polymorphism (Overloading) ---");
        Calculator calc = new Calculator();
        calc.sum(10, 20);
        calc.sum(10, 20, 30);
        calc.sum(10.5, 20.5);

        System.out.println("\n--- Dynamic Polymorphism (Overriding) ---");
        
        // IMPORTANT: The reference is of type Interface (PaymentProcessor),
        // but the actual object is of a concrete type (NetBankingProcessor).
        PaymentProcessor processor = new NetBankingProcessor();
        
        // This call is resolved at RUNTIME.
        processor.processPayment(500.0);

        // We can swap the implementation at runtime!
        processor = new UPIProcessor();
        processor.processPayment(750.0);
        
        System.out.println("\nNotice that the code calling 'processor.processPayment()' didn't CHANGE,");
        System.out.println("but the BEHAVIOR changed because the underlying object changed.");
    }
}
