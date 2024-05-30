package events;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EventListenerTests {

    // Tests if the method gets invoked after being subscribed and no longer invoked when unsubscribed
    @Test
    public void invoke(){
        // Create event handler and listener
        EventHandler eventHandler = new EventHandler();
        EventListenerExample eventListener = new EventListenerExample();

        // Get the method reference and subscribe it to the event handler
        IEventListener methodReference = eventListener::MethodToSubscribe;
        eventHandler.subscribe(methodReference);

        // invoke the method and assert
        eventHandler.invoke(eventHandler, EventArgs.Empty);
        assertEquals(eventListener.getInvocationCount(), 1);

        // invoke and assert again
        eventHandler.invoke(eventHandler, EventArgs.Empty);
        assertEquals(eventListener.getInvocationCount(), 2);

        // unsubscribe the method
        eventHandler.unsubscribe(methodReference);

        // assert if it doesn't get invoked anymore
        eventHandler.invoke(eventHandler, EventArgs.Empty);
        assertEquals(eventListener.getInvocationCount(), 2);
    }
}
