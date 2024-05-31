package com.example.neo_aucoustic_intelligence;

import Login.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginSchermController {



    @FXML
    public AnchorPane Background;

    @FXML
    public TextField errorText;

    @FXML
    public TextField gebruikersNaamInput;

    @FXML
    public Button loginButton;

    @FXML
    public TextField titelText;

    @FXML
    public PasswordField wachtwoordInput;

    @FXML
    void naarMain(ActionEvent event) {
        Login login = new Login();
        login.inloggen();
    }

}
