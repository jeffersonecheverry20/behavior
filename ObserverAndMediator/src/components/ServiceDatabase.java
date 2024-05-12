package components;

import mediator.Mediator;
import model.Product;

public class ServiceDatabase {

    private final String table;
    private Mediator mediator;

    public ServiceDatabase(final String table) {
        this.table = table;
    }

    public void setMediator(final Mediator mediator) {
        this.mediator = mediator;
    }

    public void writeDatabase(final String productName,
                              final String emailClient,
                              final String cellphoneClient,
                              final int quantity) {


        System.out.printf(
                "The new record %s was saved in the table %s. \n",
                productName,
                table);
    }
}
