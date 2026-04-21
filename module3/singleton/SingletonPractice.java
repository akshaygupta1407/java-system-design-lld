package module3.singleton;

/**
 * PRACTICE QUESTION: Singleton Pattern
 *
 * Scenario: You are building a configuration manager.
 *
 * Your goal:
 * 1. Create a `ConfigManager` class that has only one instance.
 * 2. Store configuration values in a simple key-value structure.
 * 3. Provide methods to set and get config values.
 * 4. Show that multiple references point to the same instance.
 *
 * Hint:
 * Make the constructor private and expose a static access method.
 */

class ConfigManager {
    private static ConfigManager instance;
    private java.util.Map<String, String> configValues;

    private ConfigManager() {
        configValues = new java.util.HashMap<>();
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public void setConfig(String key, String value) {
        configValues.put(key, value);
    }

    public String getConfig(String key) {
        return configValues.get(key);
    }
}

public class SingletonPractice {
    public static void main(String[] args) {
        System.out.println("--- Singleton Practice ---");

        // TODO:
        ConfigManager config1 = ConfigManager.getInstance();
        config1.setConfig("database.url", "jdbc:mysql://localhost/mydb");
        config1.setConfig("database.username", "admin");

        ConfigManager config2 = ConfigManager.getInstance();
        System.out.println("Database URL: " + config2.getConfig("database.url"));
        System.out.println("Database Username: " + config2.getConfig("database.username"));
        System.out.println("Same instance? " + (config1 == config2));

        System.out.println("Complete the TODOs to practice Singleton.");
    }
}
