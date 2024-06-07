package MessageMediator;

import Events.EventHandler;

public class MessageMediator {
    private static MessageMediator Instance;
    public final EventHandler opBerichtOntvangen = new EventHandler();
    public final EventHandler opBerichtVerstuurd = new EventHandler();


    public static MessageMediator krijgInstantie(){
        if (Instance == null){
            Instance = new MessageMediator();
        }
        return Instance;
    }

    private MessageMediator(){}
}
