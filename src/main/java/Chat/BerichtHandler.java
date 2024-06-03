package Chat;

import events.EventArgs;
import events.IEventListener;

public class BerichtHandler {
    public void send (int chatId, Bericht bericht) {
        ChatManager.chats.get(chatId).berichten.add(bericht);
    }

    private IEventListener opBerichtOntvangenReference = this::opBerichtOntvangen;
    private IEventListener opBerichtVerstuurdReference = this::opBerichtVerstuurd;

    private void opBerichtOntvangen(Object sender, EventArgs args){

    }

    private void opBerichtVerstuurd(Object sender, EventArgs args){

    }

    public BerichtHandler(){

    }
}