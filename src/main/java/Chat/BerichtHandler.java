package Chat;

public class BerichtHandler {
    public void send (int chatId, Bericht bericht) {
        Geschiedenis.chats.get(chatId).berichten.add(bericht);
    }
}