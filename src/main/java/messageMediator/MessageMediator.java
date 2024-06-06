package messageMediator;

import events.EventArgs;
import events.EventHandler;

public class MessageMediator {
    private static MessageMediator Instance;
    public final EventHandler berichtOntvangen = new EventHandler();
    public final EventHandler berichtVerstuurd = new EventHandler();


    public static MessageMediator krijgInstance(){
        if (Instance == null){
            Instance = new MessageMediator();
        }
        return Instance;
    }
}
