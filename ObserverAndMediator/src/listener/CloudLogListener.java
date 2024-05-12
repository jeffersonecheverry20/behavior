package listener;

public class CloudLogListener implements EventListener {

    public CloudLogListener() {}

    @Override
    public void update(String... resources) {
        if (resources.length != 2) {
            return;
        }
        String cloud = resources[0];
        String message = resources[1];
        System.out.printf("The log is recorded in the cloud %s and the message is %s. \n", cloud, message);
    }
}
