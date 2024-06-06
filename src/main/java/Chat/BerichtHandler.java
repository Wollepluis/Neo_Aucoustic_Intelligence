package Chat;

import Mediator.MessageMediator;
import events.EventArgs;
import events.IEventListener;

public class BerichtHandler {

    private static BerichtHandler Instance;

    public static BerichtHandler getInstance(){
        if (Instance == null){
            Instance = new BerichtHandler();
        }
        return Instance;
    }

    private void opBerichtOntvangen(Object sender, EventArgs args){
    }

    private void opBerichtVerstuurd(Object sender, EventArgs args){

    }

    private BerichtHandler(){
        MessageMediator.krijgInstantie().opBerichtOntvangen.subscribe(this::opBerichtOntvangen);
        MessageMediator.krijgInstantie().opBerichtVerstuurd.subscribe(this::opBerichtVerstuurd);
    }
}