package mediator;

public interface Mediator {

    void createOrder(final String productName,
                     final String emailClient,
                     final String cellphoneClient,
                     final int quantity);

    void sellProduct(final String productName,
                     final String emailClient,
                     final String cellphoneClient,
                     final int quantity);
}
