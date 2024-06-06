package UI;

import Login.*;
import com.example.neo_aucoustic_intelligence.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public final class SceneManager {
    public static Stage stage = new Stage();
    private static SceneManager instance;

    public static void switchScene() throws IOException {
        Stage stage = new Stage();
            System.out.println("test");
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setTitle("Main Page");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
    }

    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }
}
