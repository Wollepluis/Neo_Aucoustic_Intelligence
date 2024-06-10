package Login;

import java.util.ArrayList;

public class Login {
    public Gebruiker gebruiker;
    private String gebruikersnaam;
    private String wachtwoord;


    public Login(String gebruikersnaam, String wachtwoord) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public boolean getIngelogdStatus() {
        return gebruiker.ingelogd;
    }

    public void setIngelogdStatus(boolean newIngelogdStatus) {
        gebruiker.ingelogd = newIngelogdStatus;
    }

    public void inloggen() {

        //koppeldatabase  database.getGebruiker(gebruikersnaam, wachtwoord);

    }

    public void setGebruiker(String gebruikersnaam1, String email1, String wachtwoord1) {
        Gebruiker gebruiker1 = new Gebruiker(gebruikersnaam1, email1, wachtwoord1);

    }

    public void uitloggen() {
        ingelogdStatus = false;
    }
}
