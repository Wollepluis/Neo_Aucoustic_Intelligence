package Chat;

public class BerichtHandler {
    public void send (int chatId, Bericht bericht) {
        Chat chat = new Chat(0, "onderwerp");
        Geschiedenis.chats.add(chat);
    }
}