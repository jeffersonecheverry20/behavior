package listener;

public class LocalLogListener implements EventListener {

    public LocalLogListener() {}

    @Override
    public void update(String... resources) {
        if (resources.length != 2) {
            return;
        }
        String message = resources[1];
        System.out.printf("Write this %s message in local. \n", message);
    }
}
