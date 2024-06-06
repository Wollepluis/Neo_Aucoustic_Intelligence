package Chat;
import java.util.ArrayList;

public class ChatManager {

    private static ChatManager Instance;

    public static ChatManager getInstance(){
        if (Instance == null){
            Instance = new ChatManager();
        }
        return Instance;
    }
    private ArrayList<Chat> chats = new ArrayList(); //alle chats

    public ArrayList<Chat> getAllChats(){
        return chats;
    }

    public Chat getChat(int id){
    for (Chat chat : chats) {
        if (chat.getId() == id){
            return chat;
        }
    }
    return null;
    }

    public void addChat(Chat chat){
    chats.add(chat);
    }

    public void createNewChat(String onderwerp){
    int newId = chats.size();
    Chat newChat = new Chat(newId, onderwerp);
    addChat(newChat);
    }

    private ChatManager(){

    }
}