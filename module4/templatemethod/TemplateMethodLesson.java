package module4.templatemethod;

abstract class DataProcessor {
    public final void process() {
        readData();
        processData();
        saveData();
    }

    protected void readData() {
        System.out.println("Reading data");
    }

    protected abstract void processData();

    protected void saveData() {
        System.out.println("Saving data");
    }
}

class CsvProcessor extends DataProcessor {
    @Override
    protected void processData() {
        System.out.println("Processing CSV data");
    }
}

class JsonProcessor extends DataProcessor {
    @Override
    protected void processData() {
        System.out.println("Processing JSON data");
    }
}

public class TemplateMethodLesson {
    public static void main(String[] args) {
        System.out.println("--- Template Method Demo ---");
        DataProcessor csv = new CsvProcessor();
        DataProcessor json = new JsonProcessor();
        csv.process();
        json.process();
    }
}
