package Chat;
import java.util.ArrayList;

public class ChatManager {
    static ArrayList<Chat> chats = new ArrayList(); //alle chats
    public Chat ophalenChatGeschiedenisBericht(int chatId) {
        return chats.get(chatId);
    }
}