package module2.ocp;

/**
 * MODULE 2.2: Open/Closed Principle (OCP)
 *
 * The goal of OCP is to keep the core logic stable while allowing new
 * behavior to be added through new classes.
 */

// --- THE BAD WAY: A CLASS THAT MUST CHANGE FOR EVERY NEW DISCOUNT TYPE ---
class PriceCalculatorBad {
    public double calculateFinalPrice(String customerType, double basePrice) {
        double discount = 0.0;

        if ("REGULAR".equals(customerType)) {
            discount = 0.05;
        } else if ("PREMIUM".equals(customerType)) {
            discount = 0.10;
        } else if ("STUDENT".equals(customerType)) {
            discount = 0.15;
        }

        return basePrice - (basePrice * discount);
    }
}

// --- THE GOOD WAY: OPEN FOR EXTENSION, CLOSED FOR MODIFICATION ---
interface DiscountStrategy {
    double applyDiscount(double basePrice);
}

class RegularDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double basePrice) {
        return basePrice - (basePrice * 0.05);
    }
}

class PremiumDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double basePrice) {
        return basePrice - (basePrice * 0.10);
    }
}

class StudentDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double basePrice) {
        return basePrice - (basePrice * 0.15);
    }
}

class CheckoutService {
    private final DiscountStrategy discountStrategy;

    public CheckoutService(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double getFinalPrice(double basePrice) {
        return discountStrategy.applyDiscount(basePrice);
    }
}

public class OCPLesson {
    public static void main(String[] args) {
        System.out.println("--- OCP Demo ---");

        PriceCalculatorBad badCalculator = new PriceCalculatorBad();
        System.out.println("Bad calculator premium price: " + badCalculator.calculateFinalPrice("PREMIUM", 1000.0));

        CheckoutService regularCheckout = new CheckoutService(new RegularDiscount());
        CheckoutService premiumCheckout = new CheckoutService(new PremiumDiscount());
        CheckoutService studentCheckout = new CheckoutService(new StudentDiscount());

        System.out.println("Regular final price: " + regularCheckout.getFinalPrice(1000.0));
        System.out.println("Premium final price: " + premiumCheckout.getFinalPrice(1000.0));
        System.out.println("Student final price: " + studentCheckout.getFinalPrice(1000.0));

        System.out.println();
        System.out.println("Notice how CheckoutService did not change when we added new discount types.");
        System.out.println("We only added new classes.");
    }
}
