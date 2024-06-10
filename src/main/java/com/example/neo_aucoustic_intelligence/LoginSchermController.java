package com.example.neo_aucoustic_intelligence;

import Login.Login;
import UI.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginSchermController {


    @FXML
    private AnchorPane Background;

    @FXML
    private TextField errorText;

    @FXML
    private TextField gebruikersNaamInput;

    @FXML
    private Button loginButton;

    @FXML
    private TextField titelText;

    @FXML
    public PasswordField wachtwoordInput;

    @FXML
    void naarMain(ActionEvent event) throws IOException {
        Login login = new Login(gebruikersNaamInput.getText(), wachtwoordInput.getText());
        login.inloggen();
    }
}
