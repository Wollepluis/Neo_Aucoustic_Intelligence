package Chat;
import java.util.ArrayList;

public class Chat {
    private int id; //chatId
    private String onderwerp; //onderwerp van chat
    public ArrayList<Bericht> berichten = new ArrayList(); //alle berichten in een chat

    public void setOnderwerp(String nieuwOnderwerp) {
        onderwerp = nieuwOnderwerp;
    }

    public void voegBerichtToe(Bericht bericht) {
        berichten.add(bericht);
    }

    public Chat (int id, String onderwerp) {
        this.id = id;
        this.onderwerp = onderwerp;
    }

    public int getId() {
        return id;
    }

    public String getOnderwerp() {
        return onderwerp;
    }
}