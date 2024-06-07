package com.example.neo_aucoustic_intelligence;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloApplication extends Application {
    private static Stage inlogScherm;
    @Override
    public void start(Stage stage) throws IOException {
        inlogScherm = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginScherm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        inlogScherm.setTitle("Loginscherm");
        inlogScherm.setScene(scene);
        inlogScherm.setResizable(false);
        inlogScherm.show();
    }
    public static Stage getInlogScherm(){
        return inlogScherm;
    }

    public static void main(String[] args) {
        launch();
    }
}