package com.example.neo_aucoustic_intelligence;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import UI.*;
import java.io.IOException;

import javafx.scene.Node;

public class MainPageController {

    @FXML
    private Button Button_sendPrompt;

    @FXML
    private Button button_logoutDropdown;

    @FXML
    private ImageView button_showSidebar;

    @FXML
    private Label label_title;

    @FXML
    private ImageView newChat;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private AnchorPane sidebar;

    @FXML
    private AnchorPane sidebar_chat;

    @FXML
    private TextField txt_promptField;

    @FXML
    private Button uitlogKnop;


    @FXML
    void logoutDropdown(ActionEvent event) {
        if (uitlogKnop.isVisible()) {
            uitlogKnop.setVisible(false);
        }
        else {
            uitlogKnop.setVisible(true);
        }
    }

    @FXML
    void sendPrompt(ActionEvent event) {
       /* BerichtEventArgs berichtEventArgs = new BerichtEventArgs();
        // berichtEventArgs.chatID = ;
        berichtEventArgs.bericht = new Bericht("", txt_promptField.getText());
        MessageMediator.krijgInstance().berichtVerstuurd.invoke(this, berichtEventArgs);

        */
    }

    @FXML
    void showSidebar(MouseEvent event) {

        if (sidebar.isVisible()) {
            sidebar.setVisible(false);
            scrollpane.setVisible(false);
            txt_promptField.setPrefWidth(680);
            label_title.setLayoutX(294);

        }
        else {
            sidebar.setVisible(true);
            scrollpane.setVisible(true);
            txt_promptField.setPrefWidth(490);
            label_title.setLayoutX(384);
        }
    }

    @FXML
    void uitloggen(MouseEvent event) throws IOException {

        SceneManager.switchScene(0);

    }

    @FXML
    public void initialize() {
        uitlogKnop.setVisible(false);
    }

    @FXML
    void setNewChat(MouseEvent event1) {
        Button newButton = new Button("Voer onderwerp in"); //inhoud van button moet onderwerp zijn van de chat
        newButton.setOnAction(event -> { //hier moet komen dat de chat zichtbaar wordt op het moment dat er op de knop geduwd wordt

        });

        // Set the button's position
        double top = 10.0;
        for (Node node : sidebar_chat.getChildren()) {
            top = top + 43.0;
        }
        AnchorPane.setTopAnchor(newButton, top);
        AnchorPane.setLeftAnchor(newButton, 67.0);
        sidebar_chat.getChildren().add(newButton);
    }
}