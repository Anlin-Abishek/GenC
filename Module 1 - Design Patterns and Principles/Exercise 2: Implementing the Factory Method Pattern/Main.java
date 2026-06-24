
interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("📧 Sending Email: " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("💬 Sending SMS: " + message);
    }
}

abstract class NotificationFactory {
    public abstract Notification createNotification();

    public void sendNotification(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
}

class EmailNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class SMSNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("--- App Starts ---");

        NotificationFactory emailFactory = new EmailNotificationFactory();
        emailFactory.sendNotification("Welcome to our platform!"); 

        NotificationFactory smsFactory = new SMSNotificationFactory();
        smsFactory.sendNotification("Your OTP is 4829."); 
    }
}
