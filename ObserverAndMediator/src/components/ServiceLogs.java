package components;

import mediator.Mediator;
import publisher.Publisher;

public class ServiceLogs {

    private final Publisher publisher;
    private Mediator mediator;

    public ServiceLogs(final Publisher publisher) {
        this.publisher = publisher;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void writeLogs(final String cloud,
                          final String message) {
        this.publisher.notify("logs", cloud, message);
    }
}
