package mockupAI;

import java.util.Scanner;

public class Chat {

    protected void startChat() {
        Scanner sc = new Scanner(System.in);
        String userInput;

        System.out.println("Chat: Hello I am Aucoustic. How can I help you today?");

        while (true) {
            System.out.print("You: ");
            userInput = sc.nextLine();

            String response = getResponse(userInput);
            System.out.println("Chat: " + response);
        }
    }

    private String getResponse(String userInput) {

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
}
