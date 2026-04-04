package polymorphism;

/**
 * MODULE 1.4 PRACTICE: Dynamic Polymorphism & Extensibility
 * 
 * --- THE SCENARIO ---
 * You are building a notification system for an e-commerce platform.
 * Users can choose to receive updates via Email, SMS, or Push Notifications.
 * 
 * --- THE GOAL ---
 * 1. Create a `NotificationService` interface with a method `send(String message)`.
 * 2. Implement 3 concrete classes: `EmailNotification`, `SMSNotification`, and `PushNotification`.
 * 3. Each class should print a message like: "Sending [EMAIL/SMS/PUSH]: [message content]".
 * 4. Create a `User` class that has a `NotificationService`.
 * 5. Use Dynamic Polymorphism! The `User` should be able to "swap" their preferred 
 *    notification method at runtime.
 * 
 * --- THE CHALLENGE ---
 * Why is this better than having a huge switch statement in a single class?
 */

// TODO: Define your interface and classes here
interface NotificationService {
    void send(String message);
}

class EmailNotification implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}

class SMSNotification implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class PushNotification implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sending PUSH: " + message);
    }
}

class User {
    private String name;
    // TODO: Add a private field for the NotificationService
    private NotificationService notificationService;

    public User(String name) {
        this.name = name;
    }

    // TODO: Add a 'setNotificationService' method to "plug in" a service
    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // TODO: Add a 'notifyUser' method that calls the send() method of whatever
    public void notifyUser(String message) {
        if(notificationService!=null && message!=null && !message.isEmpty()) {
            System.out.println("Sending message to user:" + name);
            notificationService.send(message);
        }
    }
    // service is currently plugged in.
}

public class PolymorphismPractice {
    public static void main(String[] args) {
        // --- TEST YOUR CODE HERE ---
        
        // 1. Create a new User
        User user = new User("Akshay");
        // 2. Set their notification preference to Email
        NotificationService notificationService = new EmailNotification();
        user.setNotificationService(notificationService);
        // 3. Notify them
        user.notifyUser("Your payment processed successfully");
        // 4. Change their preference to SMS
        notificationService = new SMSNotification();
        user.setNotificationService(notificationService);
        // 5. Notify them again!
        user.notifyUser("Your payment processed successfully");
        
        System.out.println("--- Test the Dynamic Polymorphism ---");

        /*
            Output:
            Sending message to user:Akshay
            Sending EMAIL: Your payment processed successfully
            Sending message to user:Akshay
            Sending SMS: Your payment processed successfully
            --- Test the Dynamic Polymorphism ---
                    
        */
    }
}
