package events;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EventListenerTests {

    @Test
    public void invoke(){
        EventHandler eventHandler = new EventHandler();
        EventListenerExample eventListener = new EventListenerExample();

        IEventListener methodReference = eventListener::MethodToSubscribe;

        eventHandler.subscribe(methodReference);

        eventHandler.invoke(eventHandler, EventArgs.Empty);
        assertEquals(eventListener.getInvocationCount(), 1);

        eventHandler.invoke(eventHandler, EventArgs.Empty);
        assertEquals(eventListener.getInvocationCount(), 2);

        eventHandler.unsubscribe(methodReference);

        eventHandler.invoke(eventHandler, EventArgs.Empty);
        assertEquals(eventListener.getInvocationCount(), 2);
    }
}
