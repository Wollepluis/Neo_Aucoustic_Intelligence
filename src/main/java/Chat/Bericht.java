package Chat;

public class Bericht {
    private final String sender; //verstuurder van het bericht
    private final String bericht; //inhoud van het bericht

    public Bericht(String sender, String bericht) {
        this.sender = sender;
        this.bericht = bericht;
    }

    public String getSender() {
        return sender;
    }

    public String getBericht() {
        return bericht;
    }
}