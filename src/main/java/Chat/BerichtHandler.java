package Chat;

import Events.EventArgs;
import MessageMediator.*;

public class BerichtHandler {

    private static BerichtHandler Instance;

    public static BerichtHandler getInstance(){
        if (Instance == null){
            Instance = new BerichtHandler();
        }
        return Instance;
    }

    private void opBerichtOntvangen(Object sender, EventArgs args){
        if (!(args instanceof BerichtEventArgs)){
            return;
        }
        BerichtEventArgs berichtArgs = (BerichtEventArgs) args;
        ChatManager.getInstance().getChat(berichtArgs.chatID).voegBerichtToe(berichtArgs.bericht);
        System.out.println("BerichtHandler heeft bericht voor chat: " + berichtArgs.chatID + "ontvangen");
    }

    private void opBerichtVerstuurd(Object sender, EventArgs args){
        //MessageMediator.krijgInstantie().opBerichtVerstuurd.invoke(sender, args);
    }

    private BerichtHandler(){
        MessageMediator.krijgInstantie().opBerichtOntvangen.subscribe(this::opBerichtOntvangen);
        MessageMediator.krijgInstantie().opBerichtVerstuurd.subscribe(this::opBerichtVerstuurd);
    }
}