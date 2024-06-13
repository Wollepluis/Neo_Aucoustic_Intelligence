package Chat;
import java.util.ArrayList;

public class ChatManager {

    private static ChatManager Instance;
    private ArrayList<Chat> chats = new ArrayList(); //alle chats


    public static ChatManager getInstance(){
        if (Instance == null){
            Instance = new ChatManager();
        }
        return Instance;
    }

    public ArrayList<Chat> getAllChats(){
        return chats;
    }

    public Chat getChat(int id) {
        for (Chat chat : chats) {
            if (chat.getId() == id){
                return chat;
            }
        }
        addChat(createNewChat(id, "Nieuw onderwerp"));
        return getChat(id);
    }

    public void addChat(Chat chat){
        chats.add(chat);
    }

    public Chat createNewChat(int id, String onderwerp){
        return new Chat(id, onderwerp);
    }

    private ChatManager(){

    }
}