package events;

import java.util.ArrayList;

public class EventHandler {
    private final ArrayList<IEventListener> listeners = new ArrayList<>();

    public void subscribe(IEventListener listener){
        listeners.add(listener);
    }

    public void unsubscribe(IEventListener listener){
        listeners.remove(listener);
    }

    public void invoke(EventArgs args){
        for (IEventListener listener : listeners){
            listener.invoke(this, args);
        }
    }
}

