package Chat;
import java.util.ArrayList;

public class Geschiedenis {
    ArrayList<Chat> chats = new ArrayList(); //alle chats
    public String ophalenChatGeschiedenis(int chatId) {
        for (int i = 0; i < chats.size(); i++) {
            if (chats.get(i).getId() == chatId) {
                for (int j = 0; j < chats.get(i).berichten.size(); j++) {
                    return chats.get(i).berichten.get(j).getSender();
                    return chats.get(i).berichten.get(j).getBericht();
                }
            }
        }
    }
}