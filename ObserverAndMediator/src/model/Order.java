package model;

public class Order {

    private final String productName;
    private final String emailClient;
    private final String cellphoneClient;
    private final int quantity;

    public Order(String productName, String emailClient, String cellphoneClient, int quantity) {
        this.productName = productName;
        this.emailClient = emailClient;
        this.cellphoneClient = cellphoneClient;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public String getCellphoneClient() {
        return cellphoneClient;
    }

    public int getQuantity() {
        return quantity;
    }
}
