package AiModels;

import Chat.Bericht;
import Events.EventArgs;
import MessageMediator.*;

public class MockupAI extends AiModel{

    public MockupAI() {
        MessageMediator.krijgInstantie().opBerichtVerstuurd.subscribe(this::opBerichtVerstuurd);
    }

    private String getPrompt(String userInput) {

        String response;

        switch (userInput.toLowerCase()) {
            case "hello":
                response = "Hi there!";
                break;
            case "how are you?":
                response = "I'm just a bunch of code, but I'm functioning properly!";
                break;
            case "what is your name?":
                response = "I'm a simple chatbot.";
                break;
            default:
                response = "I'm too aucoustic to understand. Try asking something simpler.";
                break;
        }
        return response;
    }

    @Override
    protected void opBerichtVerstuurd(Object sender, EventArgs args) {
        if(!(args instanceof BerichtEventArgs)) return;
        BerichtEventArgs berichtEventArgs = (BerichtEventArgs)args;

        String reactie = getPrompt(berichtEventArgs.bericht.getBericht());

        BerichtEventArgs berichtArgs = new BerichtEventArgs();
        berichtArgs.chatID = berichtEventArgs.chatID;
        berichtArgs.bericht = new Bericht("Aucoustic Intelligence", reactie);
        MessageMediator.krijgInstantie().opBerichtOntvangen.invoke(this, berichtArgs);
        System.out.println(berichtArgs.bericht.getBericht());
    }
}
