package com.example.neo_aucoustic_intelligence;

import Chat.Bericht;
import Chat.BerichtHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import Login.Login;
import UI.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.Node;
import javafx.scene.layout.VBox;
import messageMediator.BerichtEventArgs;
import messageMediator.MessageMediator;

public class MainPageController {

    @FXML
    private Button Button_sendPrompt;

    @FXML
    private Button button_logoutDropdown;

    @FXML
    private ImageView button_showSidebar;

    @FXML
    private ScrollPane scrollpane1;

    @FXML
    private AnchorPane textUitvoer;

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
    private Label newLabel;

    @FXML
    private VBox vBox_AI;

    @FXML
    private VBox vBox_Gebruiker;

    @FXML
    private VBox vBox_sidebar;


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
        if (txt_promptField.getText().equals("")) { //try catch?
            System.out.println("Er is geen prompt text meegegeven. Probeer het opnieuw.");
        }
        else {
            BerichtEventArgs berichtEventArgs = new BerichtEventArgs();
            // berichtEventArgs.chatID = ;
            berichtEventArgs.bericht = new Bericht("", txt_promptField.getText());
            MessageMediator.krijgInstance().berichtVerstuurd.invoke(this, berichtEventArgs);

            //todo UI deel + kleur van text in prompt veld moet aangepast worden
            newLabel();
            txt_promptField.clear();
            newAIAnswer();
        }
    }

    @FXML
    void newLabel() {
        vBox_Gebruiker.setAlignment(Pos.BASELINE_RIGHT);
        vBox_Gebruiker.setSpacing(25.0);
        Label newLabel = new Label(txt_promptField.getText());
        vBox_Gebruiker.getChildren().add(newLabel);
    }

    @FXML
    void newAIAnswer() {
        vBox_AI.setAlignment(Pos.BASELINE_LEFT);
        vBox_AI.setSpacing(25.0);
        Label newLabel = new Label("Dit is een voorbeeld van een antwoord van de ai.");
        vBox_AI.getChildren().add(newLabel);
    }

    @FXML
    void showSidebar(MouseEvent event) {
        if (sidebar.isVisible()) {
            sidebar.setVisible(false);
            scrollpane.setVisible(false);
            txt_promptField.setPrefWidth(680);
            label_title.setLayoutX(294);
            vBox_AI.setPrefWidth(789);
            vBox_AI.setLayoutX(0);
            vBox_AI.setPadding(new javafx.geometry.Insets(0, 0, 0, 40));
            vBox_Gebruiker.setPrefWidth(783);
            vBox_Gebruiker.setLayoutX(0);

        }
        else {
            sidebar.setVisible(true);
            scrollpane.setVisible(true);
            txt_promptField.setPrefWidth(490);
            label_title.setLayoutX(384);
            vBox_AI.setPrefWidth(592);
            vBox_AI.setLayoutX(197);
            vBox_AI.setPadding(new javafx.geometry.Insets(0, 0, 0, 30));
            vBox_Gebruiker.setPrefWidth(586);
            vBox_Gebruiker.setLayoutX(197);
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

    public void setButtonText(Button button, String text) {
        button.setText(text);
    }

    public void setButtonId(){}
    @FXML
    void setNewChat(MouseEvent event1) {
        vBox_sidebar.setAlignment(Pos.BASELINE_CENTER);
        vBox_sidebar.setSpacing(20.0);
        vBox_sidebar.setPadding(new javafx.geometry.Insets(10, 0, 0, 0));
        Button newButton = new Button("Voer onderwerp in");
        ArrayList<Button> allButtons = new ArrayList<>();
        newButton.setId("chatButton" + allButtons.size());
        newButton.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Voer nieuwe naam in:"); // Dit moet een pop up window ofzo worden in scenebuilder
                String nieuweText = scanner.nextLine();
                newButton.setText(nieuweText);
            }
        });


        newButton.setOnAction(event -> { //todo hier moet komen dat de chat zichtbaar wordt op het moment dat er op de knop geduwd wordt
        });

        vBox_sidebar.getChildren().add(newButton);
    }
}
