package UI;

import Events.EventArgs;
import Login.*;
import com.example.neo_aucoustic_intelligence.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.security.spec.ECField;

public final class SceneManager {

    private static Stage mainScherm;
    private static Stage inlogScherm;
    private static SceneManager instance;

    // TODO verander throws IOException naar een try-catch
    public static void switchScene(int scherm) throws IOException {
        //scherm 0 = inlogpagina
        //scherm 1 = main page
        switch (scherm) {
            case 0:
                inlogScherm = new Stage();
                FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("LoginScherm.fxml"));
                Scene scene1 = new Scene(fxmlLoader1.load(), 800, 600);
                inlogScherm.setTitle("Loginscherm");
                inlogScherm.setScene(scene1);
                inlogScherm.setResizable(false);
                getMainScherm().hide();
                inlogScherm.show();
                break;
            case 1:
                mainScherm = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainPage.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 800, 600);
                mainScherm.setTitle("Main Page");
                mainScherm.setScene(scene);
                mainScherm.setResizable(false);
                if (getInlogScherm() == null) {
                    HelloApplication.getInlogScherm().hide();
                }
                else {getInlogScherm().hide();}
                mainScherm.show();
                break;
            default:
                System.out.println("Er is iets fout gegaan tijdens het wisselen van de schermen");
                break;
        }
    }
    public static Stage getMainScherm() {
        return mainScherm;
    }
    public static Stage getInlogScherm() {
        return inlogScherm;
    }
    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    // TODO add try catch for auth args
    private static void opGebruikerUitgelogd(Object sender, EventArgs args){
        AuthenticationEventArgs authArgs = (AuthenticationEventArgs) args;
        System.out.println("gebruiker is uitgelogd: " + authArgs.gebruiker.gebruikersNaam);
        try{
            SceneManager.switchScene(0);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    // TODO ook hier try catch pluhacs
    private static void opGebruikerIngelogd(Object sender, EventArgs args){
        AuthenticationEventArgs authArgs = (AuthenticationEventArgs) args;
        System.out.println("gebruiker is ingelogd: " + authArgs.gebruiker.gebruikersNaam);
        try{
            SceneManager.switchScene(1);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void initialize(){
        Autenticator.getInstance().opUitloggen.subscribe(SceneManager::opGebruikerUitgelogd);
        Autenticator.getInstance().opInloggen.subscribe(SceneManager::opGebruikerIngelogd);
    }
}
