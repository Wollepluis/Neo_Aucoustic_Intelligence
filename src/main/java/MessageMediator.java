import events.EventHandler;

public final class MessageMediator {

    private static MessageMediator instance;

    public EventHandler opBerichtVerstuurd = new EventHandler();
    public EventHandler opBerichtOntvangen = new EventHandler();

    public static MessageMediator krijgInstantie(){
        if (instance == null){
            instance = new MessageMediator();
        }
        return instance;
    }

    private MessageMediator(){

    }
}

