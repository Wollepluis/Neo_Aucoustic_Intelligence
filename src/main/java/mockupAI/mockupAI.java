package mockupAI;

import events.EventArgs;

public class mockupAI {

    public mockupAI() {
        MessageMediator.opBerichtVerstuurd.subscribe(this::opBerichtVerstuurd);
    }
//    public void startChat() {
//        Scanner sc = new Scanner(System.in);
//        String userInput;
//
//        System.out.println("Chat: Hello I am Aucoustic. How can I help you today?");
//
//        while (true) {
//            System.out.print("You: ");
//            userInput = sc.nextLine();
//
//            String response = getPrompt(userInput);
//            System.out.println("Chat: " + response);
//        }
//    }

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

    public void opBerichtVerstuurd(Object sender, EventArgs args) {
        if(!(args instanceof BerichtEventArgs)) return;
        BerichtEventArgs berichtEventArgs = (BerichtEventArgs)args;

        String reactie = getPrompt(berichtEventArgs.bericht.getContent());

        BerichtEventArgs berichtArgs = new BerichtEventArgs();
        berichtArgs.chatID = berichtArgs.chatID;
        berichtArgs.bericht = new Bericht("Aucoustic Intelligence", reactie);
        MessageMediator.krijgInstance().berichtOntvangen.invoke(null, berichtArgs);
    }
}
//Main gebeuren
//Chat chat = new Chat();
//chat.startChat();
