package module2.isp;

/**
 * MODULE 2.4: Interface Segregation Principle (ISP)
 *
 * ISP says clients should not be forced to depend on methods they do not use.
 */

// --- BAD DESIGN: A fat interface forces unrelated classes to implement
// methods they don't need.
interface MachineBad {
    void print();
    void scan();
    void fax();
}

class SimplePrinterBad implements MachineBad {
    @Override
    public void print() {
        System.out.println("Printing document...");
    }

    @Override
    public void scan() {
        throw new UnsupportedOperationException("Scanner not available");
    }

    @Override
    public void fax() {
        throw new UnsupportedOperationException("Fax not available");
    }
}

// --- GOOD DESIGN: Split interfaces by capability ---
interface Printable {
    void print();
}

interface Scannable {
    void scan();
}

interface Faxable {
    void fax();
}

class OfficePrinter implements Printable, Scannable {
    @Override
    public void print() {
        System.out.println("Office printer printing...");
    }

    @Override
    public void scan() {
        System.out.println("Office printer scanning...");
    }
}

class BasicPrinter implements Printable {
    @Override
    public void print() {
        System.out.println("Basic printer printing...");
    }
}

class AllInOnePrinter implements Printable, Scannable, Faxable {
    @Override
    public void print() {
        System.out.println("All-in-one printing...");
    }

    @Override
    public void scan() {
        System.out.println("All-in-one scanning...");
    }

    @Override
    public void fax() {
        System.out.println("All-in-one faxing...");
    }
}

public class ISPLesson {
    public static void main(String[] args) {
        System.out.println("--- ISP Demo ---");

        Printable basicPrinter = new BasicPrinter();
        Printable officePrinterAsPrintable = new OfficePrinter();
        Scannable officePrinterAsScanner = new OfficePrinter();
        AllInOnePrinter allInOnePrinter = new AllInOnePrinter();

        basicPrinter.print();
        officePrinterAsPrintable.print();
        officePrinterAsScanner.scan();
        allInOnePrinter.print();
        allInOnePrinter.scan();
        allInOnePrinter.fax();

        System.out.println();
        System.out.println("Notice how each class implements only the capabilities it needs.");
    }
}
