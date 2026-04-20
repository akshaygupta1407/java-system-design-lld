package module3.strategy;

/**
 * MODULE 3.1: Strategy Pattern
 *
 * Strategy lets you swap algorithms at runtime without changing the caller.
 */

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying Rs. " + amount + " using Credit Card");
    }
}

class UpiPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying Rs. " + amount + " using UPI");
    }
}

class NetBankingPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying Rs. " + amount + " using Net Banking");
    }
}

class Checkout {
    private PaymentStrategy paymentStrategy;

    public Checkout(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        System.out.println("Processing checkout...");
        paymentStrategy.pay(amount);
    }
}

public class StrategyLesson {
    public static void main(String[] args) {
        System.out.println("--- Strategy Demo ---");

        Checkout checkout = new Checkout(new CreditCardPayment());
        checkout.processPayment(1500.0);

        checkout.setPaymentStrategy(new UpiPayment());
        checkout.processPayment(750.0);

        checkout.setPaymentStrategy(new NetBankingPayment());
        checkout.processPayment(1200.0);

        System.out.println();
        System.out.println("Notice how Checkout did not change when the payment method changed.");
    }
}
