package module3.observer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * PRACTICE QUESTION: Observer Pattern
 *
 * Scenario: You are building a stock price monitoring system.
 *
 * Your goal:
 * 1. Create a `StockObserver` interface.
 * 2. Implement at least two observers, such as:
 *    - `MobileApp`
 *    - `WebDashboard`
 * 3. Create a `StockMarket` subject that lets observers subscribe and
 *    unsubscribe.
 * 4. Notify all observers whenever the stock price changes.
 *
 * Hint:
 * The stock market should not know details of the concrete observers.
 */

interface StockObserver {
    void update(String stockSymbol, double price);
}

class MobileApp implements StockObserver {
    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Mobile App: " + stockSymbol + " price updated to " + price);
    }
}

class WebDashboard implements StockObserver {
    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Web Dashboard: " + stockSymbol + " price updated to " + price);
    }
}

class StockMarket {
    private final List<StockObserver> observers = new ArrayList<>();
    private final Map<String, Double> stockPrices = new HashMap<>();

    public void subscribe(StockObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(StockObserver observer) {
        observers.remove(observer);
    }

    public void setStockPrice(String stockSymbol, double price) {
        stockPrices.put(stockSymbol, price);
        notifyObservers(stockSymbol, price);
    }

    public Double getStockPrice(String stockSymbol) {
        return stockPrices.get(stockSymbol);
    }

    private void notifyObservers(String stockSymbol, double price) {
        for (StockObserver observer : observers) {
            observer.update(stockSymbol, price);
        }
    }
}

public class ObserverPractice {
    public static void main(String[] args) {
        System.out.println("--- Observer Practice ---");

        // TODO:
        // 1. Define the interface and observer classes.
        // 2. Create the subject.
        // 3. Subscribe observers.
        // 4. Change stock prices and notify them.
        // 5. Unsubscribe one observer and test again.
        StockMarket market = new StockMarket();
        StockObserver mobileApp = new MobileApp();
        StockObserver webDashboard = new WebDashboard();
        market.subscribe(mobileApp);
        market.subscribe(webDashboard);
        market.setStockPrice("AAPL", 150.0);
        market.setStockPrice("GOOGL", 2800.0);

        market.unsubscribe(webDashboard);
        market.setStockPrice("AAPL", 155.0);
        System.out.println("Latest AAPL price from market: " + market.getStockPrice("AAPL"));

        System.out.println("Complete the TODOs to practice Observer.");
    }
}
