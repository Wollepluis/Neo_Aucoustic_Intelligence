package Login;

public class Gebruiker {
    private String gebruikersNaam;
    private String email;
    private String wachtwoord;

    public Gebruiker() {
    }

    public String getGebruikersNaam() {
        return gebruikersNaam;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public void setGebruikersNaam(String gebruikersNaam) {
        this.gebruikersNaam = gebruikersNaam;
    }

    public String getEmail() {
        return email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }
    /*
    public void pasGebruikersNaamAan() {
        gebruikersNaam = gebruikersNaamVeranderInput;
    }
    public void pasEmailAan () {
        email = emailVeranderInput;
    }
    public void pasWachtwoordAan() {
        wachtwoord = wachtwoordVeranderInput;
    }

     */
}