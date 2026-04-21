package module3.adapter;

/**
 * PRACTICE QUESTION: Adapter Pattern
 *
 * Scenario: You are building a payment system.
 *
 * Your goal:
 * 1. Create a `PaymentProcessor` interface with a method `pay(double amount)`.
 * 2. Implement a new processor, such as `StripeProcessor`.
 * 3. Assume you already have a legacy class called `LegacyPayPalGateway`
 *    with a method `makePayment(double amount)`.
 * 4. Create an adapter so `LegacyPayPalGateway` can be used as a
 *    `PaymentProcessor`.
 *
 * Hint:
 * Do not change the legacy class.
 */

interface PaymentProcessor {
    void pay(double amount);
}

class StripeProcessor implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}

class LegacyPayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Legacy PayPal.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private LegacyPayPalGateway legacyGateway;

    public PayPalAdapter(LegacyPayPalGateway legacyGateway) {
        this.legacyGateway = legacyGateway;
    }

    @Override
    public void pay(double amount) {
        legacyGateway.makePayment(amount);
    }
}

public class AdapterPractice {
    public static void main(String[] args) {
        System.out.println("--- Adapter Practice ---");

        PaymentProcessor stripeProcessor = new StripeProcessor();
        stripeProcessor.pay(100.0);

        LegacyPayPalGateway legacyGateway = new LegacyPayPalGateway();
        PaymentProcessor paypalAdapter = new PayPalAdapter(legacyGateway);
        paypalAdapter.pay(200.0);


        System.out.println("Complete the TODOs to practice Adapter.");
    }
}
