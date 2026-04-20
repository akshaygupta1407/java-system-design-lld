package module2.dip;

/**
 * MODULE 2.5: Dependency Inversion Principle (DIP)
 *
 * High-level modules should depend on abstractions, not concrete classes.
 */

// --- BAD DESIGN: High-level logic directly depends on a low-level class ---
class EmailServiceBad {
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}

class OrderProcessorBad {
    private final EmailServiceBad emailService = new EmailServiceBad();

    public void placeOrder(String orderId) {
        System.out.println("Placing order: " + orderId);
        emailService.sendEmail("Order " + orderId + " placed successfully");
    }
}

// --- GOOD DESIGN: Depend on an abstraction and inject the implementation ---
interface NotificationSender {
    void send(String message);
}

class EmailSender implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("EmailSender: " + message);
    }
}

class SmsSender implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("SmsSender: " + message);
    }
}

class OrderProcessor {
    private final NotificationSender notificationSender;

    public OrderProcessor(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    public void placeOrder(String orderId) {
        System.out.println("Placing order: " + orderId);
        notificationSender.send("Order " + orderId + " placed successfully");
    }
}

public class DIPLesson {
    public static void main(String[] args) {
        System.out.println("--- DIP Demo ---");

        OrderProcessorBad badProcessor = new OrderProcessorBad();
        badProcessor.placeOrder("ORD-101");

        System.out.println();

        OrderProcessor emailProcessor = new OrderProcessor(new EmailSender());
        OrderProcessor smsProcessor = new OrderProcessor(new SmsSender());

        emailProcessor.placeOrder("ORD-201");
        smsProcessor.placeOrder("ORD-202");

        System.out.println();
        System.out.println("Notice how OrderProcessor does not know which sender it gets.");
    }
}
