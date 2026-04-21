package module4.chain;

abstract class Logger {
    protected Logger next;

    public Logger setNext(Logger next) {
        this.next = next;
        return next;
    }

    public void log(String level, String message) {
        if (next != null) {
            next.log(level, message);
        }
    }
}

class InfoLogger extends Logger {
    @Override
    public void log(String level, String message) {
        if ("INFO".equals(level)) {
            System.out.println("INFO: " + message);
            return;
        }
        super.log(level, message);
    }
}

class ErrorLogger extends Logger {
    @Override
    public void log(String level, String message) {
        if ("ERROR".equals(level)) {
            System.out.println("ERROR: " + message);
            return;
        }
        super.log(level, message);
    }
}

public class ChainLesson {
    public static void main(String[] args) {
        System.out.println("--- Chain Demo ---");
        Logger chain = new InfoLogger();
        chain.setNext(new ErrorLogger());
        chain.log("INFO", "System started");
        chain.log("ERROR", "Something failed");
    }
}
