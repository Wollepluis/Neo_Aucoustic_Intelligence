package Events;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EventHandlerTests {

    // Tests if methods can be subscribed to the EventHandler
    @Test
    public void subscribe(){
        // Create a new EventHandler and listener
        EventHandler eventHandler = new EventHandler();
        EventListenerExample eventListener = new EventListenerExample();

        // Get the method reference
        IEventListener methodReference = eventListener::MethodToSubscribe;

        // Subscribe the method to the EventHandler
        eventHandler.subscribe(methodReference);

        // Assert if its subscribed
        assertTrue(eventHandler.contains(methodReference));
    }

    // Tests if a method successfully unsubscribes from the EventHandler
    @Test
    public void unsubscribe(){
        // Create a new EventHandler and listener
        EventHandler eventHandler = new EventHandler();
        EventListenerExample eventListener = new EventListenerExample();

        // Get the method reference
        IEventListener methodReference = eventListener::MethodToSubscribe;

        // Subscribe and unsubscribe the method to the EventHandler
        eventHandler.subscribe(methodReference);
        eventHandler.unsubscribe(methodReference);

        // Assert if the method successfully unsubscribed
        assertFalse(eventHandler.contains(methodReference));
    }

    // Tests if there are no runtime errors when trying to invoke methods
    @Test
    public void invoke(){
        // Create a new EventHandler and listener
        EventHandler eventHandler = new EventHandler();
        EventListenerExample eventListener = new EventListenerExample();

        // Get the method reference
        IEventListener methodReference = eventListener::MethodToSubscribe;

        // Subscribe the method to the EventHandler
        eventHandler.subscribe(methodReference);

        // Attempt to invoke the subscribed methods
        eventHandler.invoke(eventHandler, EventArgs.Empty);
    }
}
