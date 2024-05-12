package listener;

public class SMSNotificationListener implements EventListener {

    public SMSNotificationListener() {
    }

    @Override
    public void update(String... resources) {
        if (resources.length != 2) {
            return;
        }
        String cellphone = resources[1];
        System.out.printf("SMS notification send to %s. \n", cellphone);
    }
}
