package module2.dip;

/**
 * PRACTICE QUESTION: Dependency Inversion Principle
 *
 * Scenario: You are building a report generation system.
 *
 * Your goal:
 * 1. Create an abstraction for saving reports.
 * 2. Implement at least two report storage types.
 * 3. Create a high-level `ReportGenerator` that depends only on the
 *    abstraction.
 * 4. Inject the storage implementation from outside.
 *
 * Hint:
 * The report generator should not care whether the report is saved to a file,
 * database, or cloud storage.
 */

interface ReportStorage {
    void saveReport(String report);
}

class FileReportStorage implements ReportStorage {
    @Override
    public void saveReport(String report) {
        System.out.println("Saving report to file: " + report);
    }
}

class DatabaseReportStorage implements ReportStorage {
    @Override
    public void saveReport(String report) {
        System.out.println("Saving report to database: " + report);
    }
}

class ReportGenerator {
    private final ReportStorage reportStorage;

    public ReportGenerator(ReportStorage reportStorage) {
        this.reportStorage = reportStorage;
    }

    public void generateReport(String data) {
        String report = "Report based on data: " + data;
        System.out.println("Generating report...");
        reportStorage.saveReport(report);
    }
}

public class DIPPractice {
    public static void main(String[] args) {
        System.out.println("--- DIP Practice ---");

        // TODO:
        // 1. Define the abstraction.
        // 2. Create 2 storage implementations.
        // 3. Create ReportGenerator using dependency injection.
        // 4. Test the generator with different storage implementations.
        ReportStorage fileStorage = new FileReportStorage();
        ReportStorage databaseStorage = new DatabaseReportStorage();

        ReportGenerator fileGenerator = new ReportGenerator(fileStorage);
        ReportGenerator databaseGenerator = new ReportGenerator(databaseStorage);

        fileGenerator.generateReport("Sample data for file storage");
        databaseGenerator.generateReport("Sample data for database storage");


        System.out.println("Complete the TODOs to practice DIP.");

        /*
            --- DIP Practice ---
            Generating report...
            Saving report to file: Report based on data: Sample data for file storage
            Generating report...
            Saving report to database: Report based on data: Sample data for database storage
            Complete the TODOs to practice DIP.
        */
    }
}
