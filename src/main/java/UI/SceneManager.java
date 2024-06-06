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

    public static void switchScene() throws IOException {
        mainScherm = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            mainScherm.setTitle("Main Page");
            mainScherm.setScene(scene);
            mainScherm.setResizable(false);
            mainScherm.show();
            HelloApplication.getInlogScherm().hide();
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
