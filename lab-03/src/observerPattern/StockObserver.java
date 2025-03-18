package observerPattern;

import java.util.ArrayList;
import java.util.List;

public class StockObserver {
    interface Observer {
        void update(String stockName, float price);
    }

    // Concrete Observer (Investor)
    static class Investor implements Observer {
        private String name;

        public Investor(String name) {
            this.name = name;
        }

        @Override
        public void update(String stockName, float price) {
            System.out.println("Investor " + name + " notified: " + stockName + " price changed to $" + price);
        }
    }

    // Subject Interface
    interface Subject {
        void attach(Observer observer);

        void detach(Observer observer);

        void notifyObservers();
    }

    // Concrete Subject (Stock)
    static class Stock implements Subject {
        private String stockName;
        private float price;
        private List<Observer> observers = new ArrayList<>();

        public Stock(String stockName, float price) {
            this.stockName = stockName;
            this.price = price;
        }

        @Override
        public void attach(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void detach(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(stockName, price);
            }
        }

        // Setter method to update stock price and notify observers
        public void setPrice(float price) {
            this.price = price;
            System.out.println("\nStock " + stockName + " new price: $" + price);
            notifyObservers();
        }
    }

    // Main Class to Test the Implementation

        public static void main(String[] args) {
            // Create a stock
            Stock appleStock = new Stock("AAPL", 150.0f);

            // Create investors
            Investor investor1 = new Investor("Alice");
            Investor investor2 = new Investor("Bob");

            // Register investors to the stock
            appleStock.attach(investor1);
            appleStock.attach(investor2);

            // Change stock price and notify investors
            appleStock.setPrice(155.5f);
            appleStock.setPrice(160.0f);

            // Bob unsubscribes from updates
            appleStock.detach(investor2);

            // Change stock price again
            appleStock.setPrice(165.0f);
        }

}
