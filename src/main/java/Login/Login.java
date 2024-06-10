package Login;

import Database.DataObject;
import Database.MockupDatabase;
import Database.UserData;
import UI.SceneManager;

import java.io.IOException;
import java.util.ArrayList;

public class Login {
    public Gebruiker gebruiker;
    private String gebruikersnaam;
    private String wachtwoord;


    public Login(String gebruikersnaam, String wachtwoord) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setIngelogdStatus(boolean newIngelogdStatus) {
        gebruiker.ingelogd = newIngelogdStatus;
    }

    public boolean inloggen() throws IOException {
        MockupDatabase mockupDatabase  = new MockupDatabase();
        UserData userdata = mockupDatabase.getGebruiker(gebruikersnaam, wachtwoord);
        if (userdata != null) {
            SceneManager.switchScene(1);
            gebruiker.gebruikersNaam = userdata.getGebruikersnaam();
            gebruiker.wachtwoord = userdata.getWachtwoord();
            gebruiker.ingelogd = true;
            return false;
        }
            return true;
    }



    public void uitloggen() throws IOException {
        gebruiker.wachtwoord = null;
        gebruiker.gebruikersNaam = null;
        gebruiker.email = null;
        gebruiker.ingelogd = false;
        SceneManager.switchScene(0);
    }
}
