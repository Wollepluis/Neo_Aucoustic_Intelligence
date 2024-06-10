package UI;

import Login.*;
import com.example.neo_aucoustic_intelligence.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public final class SceneManager {

    private static Stage mainScherm;
    private static SceneManager instance;

    public static void switchScene(int scherm) throws IOException {
        //scherm 0 = inlogpagina
        //scherm 1 = main page
        System.out.println(scherm);
        switch (scherm) {
            case 0:
                System.out.println("test");
                getMainScherm().hide();
                HelloApplication.getInlogScherm().show();
                break;
            case 1:
                if(mainScherm == null) {
                    mainScherm = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainPage.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 800, 600);
                    mainScherm.setTitle("Main Page");
                    mainScherm.setScene(scene);
                    mainScherm.setResizable(false);
                    mainScherm.show();
                }
                HelloApplication.getInlogScherm().hide();
                getMainScherm().show();
                break;
            default:
                System.out.println("Er is iets fout gegaan tijdens het wisselen van de schermen");
                break;
        }
    }
    public static Stage getMainScherm() {
        return mainScherm;
    }
    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }
}
