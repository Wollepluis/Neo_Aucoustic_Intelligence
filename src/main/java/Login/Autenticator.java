package Login;

import Database.MockupDatabase;
import Database.UserData;
import UI.SceneManager;
import java.io.IOException;

public class Autenticator {
    public Gebruiker actieveGebruiker;

    private static Autenticator instance;
    public static Autenticator getInstance(){
        if (instance == null) {
            instance = new Autenticator();
        }
        return instance;
    }

    public boolean inloggen(String gebruikersnaam, String wachtwoord) throws IOException {
        MockupDatabase mockupDatabase = new MockupDatabase();
        UserData userdata = mockupDatabase.getGebruiker(gebruikersnaam, wachtwoord);
        if (userdata != null) {
            SceneManager.switchScene(1);
            actieveGebruiker.gebruikersNaam = userdata.getGebruikersnaam();
            actieveGebruiker.wachtwoord = userdata.getWachtwoord();
            actieveGebruiker.ingelogd = true;
            return false;
        }
        return true;
    }
    public void uitloggen() throws IOException {
        actieveGebruiker = null;
        SceneManager.switchScene(0);
    }
    private Autenticator() {

    }
}
