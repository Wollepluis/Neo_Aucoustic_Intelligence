package Login;

import com.example.neo_aucoustic_intelligence.*;
import java.util.HashMap;

public class Login {
    private static boolean ingelogdStatus;
    HashMap<String, String> gebruikers = new HashMap<String, String>();
    private String gebruikersnaam;
    private String wachtwoord;

    public Login(String gebruikersnaam, String wachtwoord) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public static boolean getIngelogdStatus(){
        return ingelogdStatus;
    }
    public static void setIngelogdStatus(boolean newIngelogdStatus){ingelogdStatus = newIngelogdStatus;}
    public void voegGebruikertoe(Gebruiker gebruiker) {
        gebruikers.put(gebruiker.getGebruikersNaam(), gebruiker.getWachtwoord());
    }

    public boolean inloggen(){
        gebruikers.put("Morris", "M123");

        if (gebruikers.get(gebruikersnaam).equals(wachtwoord)) {
            ingelogdStatus = true;
            return true;
        }
        else {
            return false;
        }
    }
    public void uitloggen(){
        ingelogdStatus = false;
    }
}