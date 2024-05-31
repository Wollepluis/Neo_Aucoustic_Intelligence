package Login;

import com.example.neo_aucoustic_intelligence.*;
import java.util.HashMap;

public class Login {
    private boolean ingelogdStatus;
    HashMap<String, String> gebruikers = new HashMap<String, String>();
    private String gebruikersnaam;
    private String wachtwoord;

    public Login(String gebruikersnaam, String wachtwoord) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public boolean getIngelogdStatus(){
        return ingelogdStatus;
    }
    public void voegGebruikertoe(Gebruiker gebruiker) {
        gebruikers.put(gebruiker.getGebruikersNaam(), gebruiker.getWachtwoord());
    }

    public void inloggen(){
        gebruikers.put("Morris", "M123");
        System.out.println("test");
        System.out.println(gebruikersnaam);

        if (gebruikers.get(gebruikersnaam).equals(wachtwoord)) {
            System.out.println("Jaaaaa");
            ingelogdStatus = true;
            //ga naar de main menu
        }
        else {
            //laat zien dat het wachtwoord en gebruikersnaam niet overeen komen
            return;
        }
        System.out.println(2);
    }
    public void uitloggen(){
        ingelogdStatus = false;
    }
}