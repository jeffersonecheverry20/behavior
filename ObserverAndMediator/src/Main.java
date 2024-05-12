import components.*;
import listener.CloudLogListener;
import listener.EmailNotificationListener;
import listener.LocalLogListener;
import listener.SMSNotificationListener;
import mediator.ConcreteMediator;
import publisher.Publisher;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Publisher publisher = getPublisher();

        // Initial Data
        String productName = "Shoes Red";
        String emailClient = "test@gmail.com";
        String cellphoneClient = "3152353231";
        String cloud = "AWS";

        // Creation Service Logs.
        ServiceLogs serviceLogs = new ServiceLogs(publisher);
        // Creation Service Notifications.
        ServiceNotifications serviceNotifications = new ServiceNotifications(publisher);
        // Creation Service Database.
        ServiceDatabase serviceDatabase = new ServiceDatabase("product");
        // Creation Service Shopping.
        ServiceShopping serviceShopping = new ServiceShopping();
        // Creation Service Order.
        ServiceOrder serviceOrder = new ServiceOrder();

        ConcreteMediator mediator = new ConcreteMediator(
                serviceLogs,
                serviceNotifications,
                serviceDatabase,
                serviceShopping,
                serviceOrder,
                publisher);

        serviceLogs.setMediator(mediator);
        serviceNotifications.setMediator(mediator);
        serviceDatabase.setMediator(mediator);
        serviceShopping.setMediator(mediator);
        serviceOrder.setMediator(mediator);

        serviceShopping.startSale(productName, emailClient, cellphoneClient, 3);
    }

    private static Publisher getPublisher() {
        Publisher publisher = new Publisher();

        String actionNotification = "notification";
        String actionLogs = "logs";

        EmailNotificationListener emailNotificationListener = new EmailNotificationListener();
        SMSNotificationListener smsNotificationListener = new SMSNotificationListener();
        LocalLogListener localLogListener = new LocalLogListener();
        CloudLogListener cloudLogListener = new CloudLogListener();
        publisher.subscribe(actionNotification, emailNotificationListener);
        publisher.subscribe(actionNotification, smsNotificationListener);
        publisher.subscribe(actionLogs, localLogListener);
        publisher.subscribe(actionLogs, cloudLogListener);
        return publisher;
    }
}