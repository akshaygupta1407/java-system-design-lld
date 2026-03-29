package abstraction;

/**
 * PRACTICE QUESTION: Abstraction
 * 
 * Objective: Design a tiny notification system using abstraction.
 * 
 * Requirements:
 * 1. Create an interface `NotificationSender` with a method `send(String message)`.
 * 2. Create three classes that implement `NotificationSender`:
 *    - `EmailSender`: Prints "Sending Email: <message>"
 *    - `SmsSender`: Prints "Sending SMS: <message>"
 *    - `PushNotificationSender`: Prints "Sending Push Notification: <message>"
 * 3. Create a `NotificationService` class.
 *    - It should accept a `NotificationSender` via its constructor (this is dependency injection via abstraction!).
 *    - It should have a method `notifyUser(String message)` which calls the `send` method of the sender.
 * 4. In the `main` method, test all 3 senders without altering the `NotificationService` logic.
 */

// 1. Define Interface here
interface NotificationSender{
    void send(String message);
}

class EmailSender implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class SmsSender implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class PushNotificationSender implements NotificationSender {
    @Override
    public void send(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
}

class NotificationService {
    NotificationSender notificationSender;
    NotificationService(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    public void notifyUser(String message) {
        notificationSender.send(message);
    }
}


// 2. Define concrete implementations (Email, SMS, Push) here

// 3. Define the NotificationService that "uses" the interface

public class AbstractionPractice {
    public static void main(String[] args) {
        System.out.println("--- Testing Abstraction ---");
        // Test it here!
        NotificationSender email = new EmailSender();
        NotificationService service = new NotificationService(email);
        service.notifyUser("Hello Abstraction!");

        /*
        Output:
        --- Testing Abstraction ---
            Sending Email: Hello Abstraction!
        */
    }
}
