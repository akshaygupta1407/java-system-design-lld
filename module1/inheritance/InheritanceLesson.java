package inheritance;

// --- THE INHERITANCE TRAP ---
class FileLogger {
    public void log(String msg) {
        System.out.println("Writing to File: " + msg);
    }
}

// Requirement: Now we want a logger that formats to JSON before writing to a file.
// Approach 1: Inheritance (Rigid & Couples)
class JsonFileLogger extends FileLogger {
    @Override
    public void log(String msg) {
        String json = "{ \"log\": \"" + msg + "\" }";
        super.log(json); 
    }
}

// What if the boss asks for a DatabaseLogger?
// Let's create `class DatabaseLogger {}`
// What if she then asks for a JsonDatabaseLogger? 
// If we use inheritance, we need `class JsonDatabaseLogger extends DatabaseLogger`.
// We are duplicating the JSON formatting logic! Class explosion happens!


// --- THE COMPOSITION SOLUTION ---

// 1. Separate the "Where we write" (Output)
interface OutputStrategy {
    void write(String data);
}

class FileOutput implements OutputStrategy {
    public void write(String data) { System.out.println("Writing to File: " + data); }
}

class DatabaseOutput implements OutputStrategy {
    public void write(String data) { System.out.println("Writing to Database: " + data); }
}

// 2. Separate the "Format" (Composition over Inheritance)
class SmartLogger {
    // SmartLogger HAS-A OutputStrategy (Composition!)
    private OutputStrategy output;

    public SmartLogger(OutputStrategy output) {
        this.output = output;
    }

    public void logRaw(String msg) {
        output.write(msg);
    }

    public void logJson(String msg) {
        String json = "{ \"log\": \"" + msg + "\" }";
        output.write(json);
    }
    
    // We can swap the output strategy AT RUNTIME!
    public void setOutput(OutputStrategy output) {
        this.output = output;
    }
}

public class InheritanceLesson {
    public static void main(String[] args) {
        System.out.println("--- Inheritance vs Composition ---");
        
        // Using Inheritance (Rigid)
        JsonFileLogger jfl = new JsonFileLogger();
        jfl.log("Error 500");

        System.out.println("\n--- Now Using Composition ---");
        
        // Using Composition (Flexible plug-and-play)
        OutputStrategy file = new FileOutput();
        OutputStrategy db = new DatabaseOutput();
        
        SmartLogger logger = new SmartLogger(file);
        logger.logJson("Error 404");
        
        // Switch to DB easily! No new classes needed.
        logger.setOutput(db);
        logger.logJson("Error 404");
    }
}
