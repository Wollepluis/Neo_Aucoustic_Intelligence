package Login;

import Database.MockupDatabase;
import Database.UserData;
import Events.EventHandler;
import UI.SceneManager;
import java.io.IOException;

public class Autenticator {
    public Gebruiker actieveGebruiker;
    public EventHandler opInloggen = new EventHandler();
    public EventHandler opUitloggen = new EventHandler();

    private static Autenticator instance;
    public static Autenticator getInstance(){
        if (instance == null) {
            instance = new Autenticator();
        }
        return instance;
    }

    public boolean inloggen(String gebruikersnaam, String wachtwoord) throws IOException {
        // Todo fix this shit later when xander ken make databas
        actieveGebruiker = new Gebruiker("Morris", "pluh@pluh.com", "ikBenWeeboo");
        AuthenticationEventArgs args = new AuthenticationEventArgs();
        args.gebruiker = actieveGebruiker;
        opInloggen.invoke(this, args);
        return true;
        /*
        MockupDatabase mockupDatabase = new MockupDatabase();
        UserData userdata = mockupDatabase.getGebruiker(gebruikersnaam, wachtwoord);
        if (userdata != null) {
            SceneManager.switchScene(1);
            actieveGebruiker.gebruikersNaam = userdata.getGebruikersnaam();
            actieveGebruiker.wachtwoord = userdata.getWachtwoord();
            actieveGebruiker.isIngelogd = true;
            return false;
        }
        return true;
        */
    }
    public void uitloggen() {
        AuthenticationEventArgs args = new AuthenticationEventArgs();
        args.gebruiker = actieveGebruiker;
        opUitloggen.invoke(this, args);
        actieveGebruiker = null;
    }
    private Autenticator() {

    }
}
