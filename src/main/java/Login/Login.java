package Login;

import com.example.neo_aucoustic_intelligence.*;

import java.util.HashMap;

public class Login {
    private boolean ingelogdStatus;
    LoginSchermController loginSchermController = new LoginSchermController();
    HashMap<String, String> gebruikers = new HashMap<String, String>();


    public boolean getIngelogdStatus(){
        return ingelogdStatus;
    }
    public void voegGebruikertoe(Gebruiker gebruiker) {
        gebruikers.put(gebruiker.getGebruikersNaam(), gebruiker.getWachtwoord());
    }

    public void inloggen(){
        if (gebruikers.get(loginSchermController.gebruikersNaamInput.getText()).equals(loginSchermController.wachtwoordInput.getText())) {


            ingelogdStatus = true;
            //ga naar de main menu
        }
        else {
            //laat zien dat het wachtwoord en gebruikersnaam niet overeen komen
        }
    }
    public void uitloggen(){
        ingelogdStatus = false;
    }
}