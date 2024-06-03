package Chat;

public class BerichtHandler {
    public void send (int chatId, Bericht bericht) {
        ChatManager.chats.get(chatId).berichten.add(bericht);
    }
}