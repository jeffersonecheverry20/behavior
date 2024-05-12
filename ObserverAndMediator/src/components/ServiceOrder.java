package components;

import mediator.Mediator;
import model.Order;

public class ServiceOrder {

    private Mediator mediator;

    public ServiceOrder() {}

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public Order createOrder(final String productName,
                             final String emailClient,
                             final String cellphoneClient,
                             final int quantity) {
        this.mediator.sellProduct(productName, emailClient, cellphoneClient, quantity);
        if (productName == null || productName.isBlank()) {
            return null;
        }
        return new Order(productName, emailClient, cellphoneClient, quantity);
    }
}
