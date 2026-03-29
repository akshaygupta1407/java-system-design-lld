package encapsulation;

public class EncapsulationLesson {

    // 1. Data Hiding (Private fields)
    // The internal state is hidden from the outside world.
    private String name;
    private double balance;

    // 2. Encapsulation (Grouping data and methods together inside this class)
    public EncapsulationLesson(String name, double initialBalance) {
        this.name = name;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Initial balance cannot be negative. Setting to 0.");
        }
    }

    // 3. Controlled Access (Getters and Setters)
    // We only expose public methods to interact with the hidden data.
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". Remaining balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal. Overdrafts not permitted.");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Encapsulation Demo ---");
        // We interact with the account ONLY via its public methods.
        EncapsulationLesson myAccount = new EncapsulationLesson("John Doe", 100.0);
        
        // This won't even compile because 'balance' is private!
        // myAccount.balance = -5000.0; // ERROR

        myAccount.deposit(50.0);
        myAccount.withdraw(200.0); // Should fail gracefully
        myAccount.withdraw(30.0);
    }
}
