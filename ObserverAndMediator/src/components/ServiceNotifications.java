package components;

import mediator.Mediator;
import publisher.Publisher;

public class ServiceNotifications {

    private final Publisher publisher;
    private Mediator mediator;

    public ServiceNotifications(final Publisher publisher) {
        this.publisher = publisher;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void sendNotification(final String emailClient,
                                 final String cellphoneClient) {
        this.publisher.notify("notification", emailClient, cellphoneClient);
    }
}
