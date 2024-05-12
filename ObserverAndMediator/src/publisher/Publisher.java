package publisher;

import listener.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Publisher {

    private final Map<String, List<EventListener>> listeners;

    public Publisher() {
        this.listeners = new HashMap<>();
        listeners.put("notification", new ArrayList<>());
        listeners.put("logs", new ArrayList<>());
    }

    public void subscribe(final String action, final EventListener listener) {
        List<EventListener> existingListeners = listeners.get(action);
        existingListeners.add(listener);
    }

    public void unsubscribe(final String action, final EventListener listener) {
        List<EventListener> existingListeners = listeners.get(action);
        existingListeners.remove(listener);
    }

    public void notify(final String action,
                       final String... resources) {
        List<EventListener> existingListeners = listeners.get(action);
        for (EventListener listener: existingListeners) {
            listener.update(resources);
        }
    }
}
