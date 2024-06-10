import AiModels.AiModel;
import AiModels.MockupAI;
import Chat.Bericht;
import Chat.BerichtHandler;
import Events.EventArgs;
import MessageMediator.BerichtEventArgs;
import MessageMediator.MessageMediator;

public class Main {
    public static void main(String[] args){
        AiModel aiModel = new MockupAI();
        BerichtHandler berichtHandler = BerichtHandler.getInstance();

        BerichtEventArgs a = new BerichtEventArgs();
        a.chatID = 1;
        a.bericht = new Bericht("banaan","hellow world");

        MessageMediator.krijgInstantie().opBerichtVerstuurd.invoke(null, a);
    }
}
