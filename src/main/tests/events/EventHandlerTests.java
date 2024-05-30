package events;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EventHandlerTests {

    @Test
    public void subscribe(){
        EventHandler eventHandler = new EventHandler();
        EventListenerExample eventListener = new EventListenerExample();

        IEventListener methodReference = eventListener::MethodToSubscribe;

        eventHandler.subscribe(methodReference);

        assertTrue(eventHandler.contains(methodReference));
    }

    @Test
    public void unsubscribe(){
        EventHandler eventHandler = new EventHandler();
        EventListenerExample eventListener = new EventListenerExample();

        IEventListener methodReference = eventListener::MethodToSubscribe;

        eventHandler.subscribe(methodReference);
        eventHandler.unsubscribe(methodReference);

        assertFalse(eventHandler.contains(methodReference));
    }

    @Test
    public void invoke(){
        EventHandler eventHandler = new EventHandler();
        EventListenerExample eventListener = new EventListenerExample();

        IEventListener methodReference = eventListener::MethodToSubscribe;

        eventHandler.subscribe(methodReference);

        eventHandler.invoke(eventHandler, EventArgs.Empty);
    }
}
