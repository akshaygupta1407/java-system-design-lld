package module2.srp;

/**
 * MODULE 2.1 PRACTICE: Referencing Single Responsibility Principle
 * 
 * --- THE SCENARIO ---
 * You have a class `UserManagement` that handles multiple responsibilities:
 * 1.  Storing user details.
 * 2.  Logging messages to the console.
 * 3.  Sending a welcome email to the user.
 * 
 * --- THE GOAL ---
 * 1.  Identify the separate responsibilities.
 * 2.  Create separate classes for each responsibility:
 *     - `User`: Only for data (Name, Email).
 *     - `Logger`: Only for logging.
 *     - `EmailService`: Only for sending emails.
 * 3.  Refactor the code into a "Good" implementation!
 */

// --- THE MESSY CLASS (REFACTOR THIS) ---
class UserManagement {
    private String name;
    private String email;

    public void registerUser(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }
}

// TODO: Create your SRP-compliant classes here
class UserManagementLog {
    public void logging(UserManagement userManagement) {
        System.out.println("[LOG]: Registering user: " + userManagement.getName());
    }
}

class UserManagementRepo {
    public void saveToDB(UserManagement userManagement) {
        System.out.println("[DB]: Saving user " + userManagement.getName() + " to MySQL.");
    }
}

class UserManagementComms {
    public void sendComms(UserManagement userManagement) {
        System.out.println("[EMAIL]: Sending welcome email to " + userManagement.getEmail());
    }
}

public class SRPPractice {
    public static void main(String[] args) {
        // --- TEST YOUR REFACTORED CODE HERE ---
        
        System.out.println("--- Test the SRP implementation ---");
        
        // 1. Create a User
        UserManagement userManagement = new UserManagement();
        userManagement.registerUser("Akshay", "ag@gmail.com");
        // 2. Use a separate Logger to log the registration
        UserManagementLog userManagementLog = new UserManagementLog();
        userManagementLog.logging(userManagement);
        // 3. Use an EmailService to send the email
        UserManagementComms userManagementComms = new UserManagementComms();
        userManagementComms.sendComms(userManagement);

        /*
            Output
            --- Test the SRP implementation ---
            [LOG]: Registering user: Akshay
            [EMAIL]: Sending welcome email to ag@gmail.com
        */
    }
}
