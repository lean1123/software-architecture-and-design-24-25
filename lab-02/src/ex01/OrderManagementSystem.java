package ex01;

public class OrderManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== State Pattern ===");
        StatePatternTest.OrderContext order = new StatePatternTest.OrderContext();
        order.processOrder();
        order.processOrder();
        order.processOrder();


        System.out.println("\n=== Strategy Pattern ===");
        StrategyPatternTest.OrderProcessor processor = new StrategyPatternTest.OrderProcessor();

        processor.setStrategy(new StrategyPatternTest.VerifyOrder());
        processor.process();

        processor.setStrategy(new StrategyPatternTest.PackOrder());
        processor.process();

        processor.setStrategy(new StrategyPatternTest.ShipOrder());
        processor.process();


        System.out.println("\n=== Decorator Pattern ===");
        DecoratorPatterntest.Notification basicNotification = new DecoratorPatterntest.BasicNotification();
        DecoratorPatterntest.Notification emailNotification = new DecoratorPatterntest.EmailNotificationDecorator(basicNotification);
        DecoratorPatterntest.Notification smsNotification = new DecoratorPatterntest.SMSNotificationDecorator(emailNotification);

        smsNotification.send();
    }
}

