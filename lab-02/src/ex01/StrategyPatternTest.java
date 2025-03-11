package ex01;

public class StrategyPatternTest {

    interface OrderProcessingStrategy {
        void execute();
    }


    static class VerifyOrder implements OrderProcessingStrategy {
        @Override
        public void execute() {
            System.out.println("Verifying order details...");
        }
    }


    static class PackOrder implements OrderProcessingStrategy {
        @Override
        public void execute() {
            System.out.println("Packing the order...");
        }
    }

    static class ShipOrder implements OrderProcessingStrategy {
        @Override
        public void execute() {
            System.out.println("Shipping the order...");
        }
    }


    static class OrderProcessor {
        private OrderProcessingStrategy strategy;

        public void setStrategy(OrderProcessingStrategy strategy) {
            this.strategy = strategy;
        }

        public void process() {
            strategy.execute();
        }
    }


}
