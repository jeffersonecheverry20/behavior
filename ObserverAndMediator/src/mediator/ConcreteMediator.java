package mediator;

import listener.EventListener;
import model.Order;
import model.Product;
import publisher.Publisher;
import components.ServiceDatabase;
import components.ServiceLogs;
import components.ServiceNotifications;
import components.ServiceShopping;
import components.ServiceOrder;

public class ConcreteMediator implements Mediator {

    private final ServiceLogs serviceLogs;
    private final ServiceNotifications serviceNotifications;
    private final ServiceDatabase serviceDatabase;
    private final ServiceShopping serviceShopping;
    private final ServiceOrder serviceOrder;
    private final Publisher publisher;

    public ConcreteMediator(final ServiceLogs serviceLogs,
                            final ServiceNotifications serviceNotifications,
                            final ServiceDatabase serviceDatabase,
                            final ServiceShopping serviceShopping,
                            final ServiceOrder serviceOrder,
                            final Publisher publisher) {
        this.serviceLogs = serviceLogs;
        this.serviceNotifications = serviceNotifications;
        this.serviceDatabase = serviceDatabase;
        this.serviceShopping = serviceShopping;
        this.serviceOrder = serviceOrder;
        this.publisher = publisher;
    }

    public void subscribeNewListener(final String action,
                                     final EventListener eventListener) {
        publisher.subscribe(action, eventListener);
    }

    @Override
    public void createOrder(final String productName,
                            final String emailClient,
                            final String cellphoneClient,
                            final int quantity) {
        Order order = this.serviceOrder.createOrder(productName, emailClient, cellphoneClient, quantity);

        if (order != null) {
            String message = String.format("The order with the product %s was created", productName);
            this.serviceDatabase.writeDatabase(productName, emailClient, cellphoneClient, quantity);
            this.serviceLogs.writeLogs("AWS", message);
        }

    }

    @Override
    public void sellProduct(final String productName,
                            final String emailClient,
                            final String cellphoneClient,
                            final int quantity) {
        Product product = this.serviceShopping.sellProduct(productName, emailClient, cellphoneClient, quantity);

        if (product != null) {
            this.serviceNotifications.sendNotification(emailClient, cellphoneClient);
        }
    }
}
