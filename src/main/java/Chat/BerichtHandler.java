package Chat;

import Mediator.MessageMediator;
import events.EventArgs;
import events.IEventListener;

public class BerichtHandler {
    public void send (int chatId, Bericht bericht) {
        ChatManager.chats.get(chatId).berichten.add(bericht);
    }


    private void opBerichtOntvangen(Object sender, EventArgs args){

    }

    private void opBerichtVerstuurd(Object sender, EventArgs args){

    }

    public BerichtHandler(){
        MessageMediator.krijgInstantie().opBerichtOntvangen.subscribe(this::opBerichtOntvangen);
        MessageMediator.krijgInstantie().opBerichtVerstuurd.subscribe(this::opBerichtVerstuurd);
    }
}