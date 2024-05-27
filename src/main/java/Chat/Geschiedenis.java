package Chat;
import java.util.ArrayList;

public class Geschiedenis {
    static ArrayList<Chat> chats = new ArrayList(); //alle chats
    public String ophalenChatGeschiedenisBericht(int chatId) {
        for (int i = 0; i < chats.size(); i++) {
            if (chats.get(i).getId() == chatId) {
                for (int j = 0; j < chats.get(i).berichten.size(); j++) {
                    return chats.get(i).berichten.get(j).getBericht();
                }
            }
        }
    }

    public String ophalenChatGeschiedenisSender(int chatId) {
        for (int i = 0; i < chats.size(); i++) {
            if (chats.get(i).getId() == chatId) {
                for (int j = 0; j < chats.get(i).berichten.size(); j++) {
                    return chats.get(i).berichten.get(j).getSender();
                }
            }
        }
    }
}