package module2.ocp;

/**
 * PRACTICE QUESTION: Open/Closed Principle
 *
 * Scenario: A food delivery app gives different delivery fee discounts based
 * on membership type.
 *
 * Your goal:
 * 1. Create a `DeliveryDiscount` interface.
 * 2. Implement `NoDiscount`, `GoldDiscount`, and `PlatinumDiscount`.
 * 3. Create `DeliveryFeeCalculator` that depends only on the interface.
 * 4. Make sure you can add a new discount later without changing the
 *    calculator logic.
 *
 * Important:
 * - Create the classes yourself.
 * - Do not look at the lesson until you try it first.
 * - Try to keep the calculator closed for modification.
 */

interface DeliveryDiscount {
    double applyDiscount(double originalFee);
}

class NoDiscount implements DeliveryDiscount {
    @Override
    public double applyDiscount(double originalFee) {
        return originalFee;
    }
}

class GoldDiscount implements DeliveryDiscount {
    @Override
    public double applyDiscount(double originalFee) {
        return originalFee - (originalFee * 0.05);
    }
}

class PlatinumDiscount implements DeliveryDiscount {
    @Override
    public double applyDiscount(double originalFee) {
        return originalFee - (originalFee * 0.1);
    }
}

class DeliveryFeeCalculator {
    private DeliveryDiscount deliveryDiscount;

    DeliveryFeeCalculator(DeliveryDiscount deliveryDiscount) {
        this.deliveryDiscount = deliveryDiscount;
    }

    public double getDiscount(double originalFee) {
        return deliveryDiscount.applyDiscount(originalFee);
    }
}

public class OCPPractice {
    public static void main(String[] args) {
        System.out.println("--- OCP Practice ---");

        // TODO:
        // 1. Create the interface and classes needed for this exercise.
        // 2. Instantiate each discount type.
        // 3. Pass each one into DeliveryFeeCalculator.
        // 4. Print the final fee for each case.
        // 5. Add one extra discount type of your own without changing the calculator.
        final DeliveryDiscount deliveryDiscount = new NoDiscount();
        DeliveryFeeCalculator deliveryFeeCalculator = new DeliveryFeeCalculator(deliveryDiscount);
        System.out.println(deliveryFeeCalculator.getDiscount(100));

        final DeliveryDiscount deliveryDiscountGold = new GoldDiscount();
        DeliveryFeeCalculator deliveryFeeCalculatorGold = new DeliveryFeeCalculator(deliveryDiscountGold);
        System.out.println(deliveryFeeCalculatorGold.getDiscount(100));

        final DeliveryDiscount deliveryDiscountPlatinum = new PlatinumDiscount();
        DeliveryFeeCalculator deliveryFeeCalculatorPlatinum = new DeliveryFeeCalculator(deliveryDiscountPlatinum);
        System.out.println(deliveryFeeCalculatorPlatinum.getDiscount(100));

        System.out.println("Build the classes yourself to practice OCP.");
    }
}
