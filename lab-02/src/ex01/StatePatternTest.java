package ex01;

public class StatePatternTest {
    interface OrderState {
        void handleOrder(OrderContext context);
    }


    static class NewOrder implements OrderState {
        @Override
        public void handleOrder(OrderContext context) {
            System.out.println("Checking order information...");
            context.setState(new Processing());
        }
    }


    static class Processing implements OrderState {
        @Override
        public void handleOrder(OrderContext context) {
            System.out.println("Packing and shipping order...");
            context.setState(new Delivered());
        }
    }


    static class Delivered implements OrderState {
        @Override
        public void handleOrder(OrderContext context) {
            System.out.println("Order has been delivered!");
        }
    }


    class Canceled implements OrderState {
        @Override
        public void handleOrder(OrderContext context) {
            System.out.println("Order has been canceled and refunded.");
        }
    }


    static class OrderContext {
        private OrderState state;

        public OrderContext() {
            this.state = new NewOrder();
        }

        public void setState(OrderState state) {
            this.state = state;
        }

        public void processOrder() {
            state.handleOrder(this);
        }
    }



}
