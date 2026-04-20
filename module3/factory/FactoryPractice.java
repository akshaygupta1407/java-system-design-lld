package module3.factory;

/**
 * PRACTICE QUESTION: Factory Pattern
 *
 * Scenario: You are building a document export system.
 *
 * Your goal:
 * 1. Create a `Document` interface.
 * 2. Implement three document types:
 *    - `PdfDocument`
 *    - `WordDocument`
 *    - `ExcelDocument`
 * 3. Create a `DocumentFactory` that returns the correct document based on
 *    input type.
 * 4. Use the factory in `main` to create and export documents.
 *
 * Hint:
 * Avoid creating the document objects directly in `main`.
 */

interface Document {
    void export();
}

class PdfDocument implements Document {
    @Override
    public void export() {
        System.out.println("Exporting document as PDF");
    }
}

class WordDocument implements Document {
    @Override
    public void export() {
        System.out.println("Exporting document as Word");
    }
}

class ExcelDocument implements Document {
    @Override
    public void export() {
        System.out.println("Exporting document as Excel");
    }
}

class DocumentFactory {
    public Document createDocument(String type) {
        if("PDF".equalsIgnoreCase(type)) {
            return new PdfDocument();
        }
        if("WORD".equalsIgnoreCase(type)) {
            return new WordDocument();  
        }
        if("EXCEL".equalsIgnoreCase(type)) {
            return new ExcelDocument();
        }
        throw new IllegalArgumentException("Unknown document type: " + type);
    }
}

public class FactoryPractice {
    public static void main(String[] args) {
        System.out.println("--- Factory Practice ---");

        // TODO:
        // 1. Define the interface and document types.
        // 2. Implement the factory.
        // 3. Create documents using the factory.
        // 4. Export each document.
        DocumentFactory factory = new DocumentFactory();
        Document pdf = factory.createDocument("PDF");
        Document word = factory.createDocument("WORD"); 
        Document excel = factory.createDocument("EXCEL");

        pdf.export();
        word.export();
        excel.export();

        System.out.println("Complete the TODOs to practice Factory.");
    }
}
