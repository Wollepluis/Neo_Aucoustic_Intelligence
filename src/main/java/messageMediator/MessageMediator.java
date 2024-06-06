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

    public void opBerichtOntvangen(Object sender, EventArgs args){
        berichtOntvangen.invoke(sender, args);
    }

    public void opBerichtVerstuurd(Object sender, EventArgs args){
        berichtVerstuurd.invoke(sender, args);
    }
}
