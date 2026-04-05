package module2.lsp;

/**
 * PRACTICE QUESTION: Liskov Substitution Principle
 *
 * Scenario: You are designing a payment system.
 *
 * Goal:
 * 1. Create a parent contract called `RefundablePayment`.
 * 2. Implement two payment types that can be refunded.
 * 3. Implement one payment type that cannot be refunded.
 * 4. Make sure the non-refundable payment is not forced into a bad parent
 *    contract.
 *
 * Hint:
 * If a class cannot support an operation, it should not inherit from a parent
 * that demands that operation.
 */

interface RefundablePayment {
    void refund(double amount);
}

class UpiPayment implements RefundablePayment {
    @Override
    public void refund(double amount) {
        System.out.println("Refunding Rs. " + amount + " via UPI");
    }
}

class NetBankingPayment implements RefundablePayment {
    @Override
    public void refund(double amount) {
        System.out.println("Refunding Rs. " + amount + " via Net Banking");
    }
}

class CashOnDeliveryPayment {
    public void markAsNonRefundable(double amount) {
        System.out.println("COD payment of Rs. " + amount + " is not refundable");
    }
}

class RefundService {
    public void processRefund(RefundablePayment payment, double amount) {
        payment.refund(amount);
    }
}

public class LSPPractice {
    public static void main(String[] args) {
        System.out.println("--- LSP Practice ---");

        RefundService refundService = new RefundService();

        RefundablePayment upi = new UpiPayment();
        RefundablePayment netBanking = new NetBankingPayment();

        refundService.processRefund(upi, 100);
        refundService.processRefund(netBanking, 100);

        CashOnDeliveryPayment cod = new CashOnDeliveryPayment();
        cod.markAsNonRefundable(100);

        System.out.println("Complete the TODOs to practice LSP.");
    }
}
