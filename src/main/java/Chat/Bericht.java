package Chat;

public class Bericht {
    private String sender; //verstuurder van het bericht
    private String bericht; //inhoud van het bericht

    public String getSender() {
        return sender;
    }

    public String getBericht() {
        return bericht;
    }

    public void setSender(String newSender) {
        this.sender = newSender;
    }

    public void setBericht(String newBericht) {
        this.bericht = newBericht;
    }
}