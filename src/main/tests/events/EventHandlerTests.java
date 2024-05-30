package events;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EventHandlerTests {
    @Test
    public void Instantiation(){
        EventHandler a = new EventHandler();
        assertNotNull(a);
    }
}
