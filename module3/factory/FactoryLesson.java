package module3.factory;

/**
 * MODULE 3.2: Factory Pattern
 *
 * Factory centralizes object creation so callers do not need to know concrete
 * class names.
 */

interface Payment {
    void pay(double amount);
}

class CardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs. " + amount + " by Card");
    }
}

class UpiPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs. " + amount + " by UPI");
    }
}

class CashPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs. " + amount + " by Cash");
    }
}

class PaymentFactory {
    public Payment createPayment(String type) {
        if ("CARD".equalsIgnoreCase(type)) {
            return new CardPayment();
        }
        if ("UPI".equalsIgnoreCase(type)) {
            return new UpiPayment();
        }
        if ("CASH".equalsIgnoreCase(type)) {
            return new CashPayment();
        }
        throw new IllegalArgumentException("Unknown payment type: " + type);
    }
}

public class FactoryLesson {
    public static void main(String[] args) {
        System.out.println("--- Factory Demo ---");

        PaymentFactory factory = new PaymentFactory();
        Payment payment1 = factory.createPayment("CARD");
        Payment payment2 = factory.createPayment("UPI");
        Payment payment3 = factory.createPayment("CASH");

        payment1.pay(500);
        payment2.pay(250);
        payment3.pay(100);

        System.out.println();
        System.out.println("Notice how the caller asks the factory, not the concrete class.");
    }
}
