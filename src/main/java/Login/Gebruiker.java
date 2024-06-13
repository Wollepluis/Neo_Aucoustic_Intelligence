package Login;

public class Gebruiker {
    public String gebruikersNaam;
    public String email;
    public String wachtwoord;
    public boolean ingelogd;

    public Gebruiker(String gebruikersNaam, String email, String wachtwoord) {
        this.gebruikersNaam = gebruikersNaam;
        this.email = email;
        this.wachtwoord = wachtwoord;
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