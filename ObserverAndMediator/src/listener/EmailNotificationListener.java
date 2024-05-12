package listener;

public class EmailNotificationListener implements EventListener {

    public EmailNotificationListener() {
    }

    @Override
    public void update(String... resources) {
        if (resources.length != 2) {
            return;
        }
        String email = resources[0];
        System.out.printf("Email notification send to %s. \n", email);
    }
}
