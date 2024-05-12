package components;

import mediator.Mediator;
import model.Order;
import model.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ServiceShopping {

    private static final Map<String, Integer> productNameToStock;

    static {
        productNameToStock = new HashMap<>();
        productNameToStock.put("Shoes Red", 10);
        productNameToStock.put("Shoes blues", 10);
        productNameToStock.put("t-shirt blues", 10);
    }

    private Mediator mediator;
    private boolean wasSold;

    public ServiceShopping() {}

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public Product sellProduct(final String productName,
                               final String emailClient,
                               final String cellphoneClient,
                               final int quantity) {
        boolean hasStock = this.decreaseStock(productName, quantity);

        if (!hasStock) {
            return null;
        }

        System.out.printf(
                "The product %s was sold to the client %s with the cellphone %s.",
                productName,
                emailClient,
                cellphoneClient);
        Product productToSell = new Product();
        productToSell.setReferenceID(UUID.randomUUID().toString());
        productToSell.setProductName(productName);

        return productToSell;
    }

    private boolean decreaseStock(final String productName,
                                  final Integer decreaseStock) {
        if (!productNameToStock.containsKey(productName)) {
            return false;
        }

        Integer currentStock = productNameToStock.get(productName);
        if (decreaseStock > currentStock) {
            return false;
        }

        productNameToStock.put(productName, currentStock - decreaseStock);
        System.out.printf(
                "The product %s was decreased in this quantity %s.",
                productName,
                decreaseStock);
        return true;
    }

    public void startSale(final String productName,
                          final String emailClient,
                          final String cellphoneClient,
                          final int quantity) {
        this.mediator.createOrder(productName, emailClient, cellphoneClient, quantity);
    }
}
