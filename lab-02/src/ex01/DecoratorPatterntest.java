package ex01;

public class DecoratorPatterntest {

    interface Notification {
        void send();
    }


    static class BasicNotification implements Notification {
        @Override
        public void send() {
            System.out.println("Sending basic notification...");
        }
    }


    static class EmailNotificationDecorator implements Notification {
        private Notification notification;

        public EmailNotificationDecorator(Notification notification) {
            this.notification = notification;
        }

        @Override
        public void send() {
            notification.send();
            System.out.println("Sending email notification...");
        }
    }


    static class SMSNotificationDecorator implements Notification {
        private Notification notification;

        public SMSNotificationDecorator(Notification notification) {
            this.notification = notification;
        }

        @Override
        public void send() {
            notification.send();
            System.out.println("Sending SMS notification...");
        }
    }

}
