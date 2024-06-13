package com.example.neo_aucoustic_intelligence;

import Chat.Bericht;
import Chat.BerichtHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import messageMediator.BerichtEventArgs;
import messageMediator.MessageMediator;

public class MainPageController {

    @FXML
    private Button Button_sendPrompt;

    @FXML
    private Button button_aanpassenEmail;

    @FXML
    private Button button_aanpassenGebruikersnaam;

    @FXML
    private Button button_aanpassenWachtwoord;

    @FXML
    private Button button_bevestigenGegevens;

    @FXML
    private Button button_gegevensAanpassen;

    @FXML
    private Button button_logoutDropdown;

    @FXML
    private Button button_popupOnderwerp;

    @FXML
    private Button button_cancelGegevens;

    @FXML
    private ImageView button_showSidebar;

    @FXML
    private Label label_title;

    @FXML
    private ImageView newChat;

    @FXML
    private PasswordField passwordField_aanpassenGegevens;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private ScrollPane scrollpane1;

    @FXML
    private AnchorPane sidebar;

    @FXML
    private AnchorPane sidebar_chat;

    @FXML
    private AnchorPane textUitvoer;

    @FXML
    private Text text_aanpassenGegevens;

    @FXML
    private TextField textfield_aanpassenGegevens;

    @FXML
    private TextField textfield_popupOnderwerp;

    @FXML
    private TitledPane titledpane_aanpassenGegevens;

    @FXML
    private TitledPane titledpane_popupOnderwerp;

    @FXML
    private TextField txt_promptField;

    @FXML
    private Button uitlogKnop;

    @FXML
    private VBox vBox_AI;

    @FXML
    private VBox vBox_Gebruiker;

    @FXML
    private VBox vBox_sidebar;


    private ArrayList<Button> allButtons = new ArrayList<>();


    @FXML
    void logoutDropdown(ActionEvent event) {
        if (uitlogKnop.isVisible()) {
            uitlogKnop.setVisible(false);
            button_gegevensAanpassen.setVisible(false);
        }
        else {
            uitlogKnop.setVisible(true);
            button_gegevensAanpassen.setVisible(true);
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

    public void setButtonText(Button newButton) {
        System.out.println("test2");
        titledpane_popupOnderwerp.setVisible(true);
        button_popupOnderwerp.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                newButton.setText(textfield_popupOnderwerp.getText());
                titledpane_popupOnderwerp.setVisible(false);
            }
        });
    }

    @FXML
    void setNewChat(MouseEvent event1) {
        vBox_sidebar.setAlignment(Pos.BASELINE_CENTER);
        vBox_sidebar.setSpacing(20.0);
        vBox_sidebar.setPadding(new javafx.geometry.Insets(10, 0, 0, 0));

        Button newButton = new Button("Voer onderwerp in");
        newButton.setId("chatButton" + allButtons.size());
        allButtons.add(newButton);

        newButton.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                setButtonText(newButton);
                titledpane_popupOnderwerp.setVisible(true);
            }
        });


        // test

        // Add the newButton to a layout pane or a container (not shown in your snippet).

        //newButton.setOnAction(event -> { //todo hier moet komen dat de chat zichtbaar wordt op het moment dat er op de knop geduwd wordt

        vBox_sidebar.getChildren().add(newButton);
    }

    public void aanpassenGegevens() {
        titledpane_aanpassenGegevens.setVisible(true);
        button_aanpassenGebruikersnaam.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                button_aanpassenEmail.setVisible(false);
                button_aanpassenWachtwoord.setVisible(false);
                button_aanpassenGebruikersnaam.setVisible(false);
                text_aanpassenGegevens.setText("Voer uw nieuwe gebruikersnaam in");
                textfield_aanpassenGegevens.setVisible(true);
                button_bevestigenGegevens.setVisible(true);
                button_cancelGegevens.setVisible(true);
                button_bevestigenGegevens.setOnMouseClicked(event1 -> {
                    if (event1.getButton() == MouseButton.PRIMARY) {
                        //Hier moet dan komen dat textfield_aanpassengegevens de nieuwe gebruikersnaam wordt van de gebruiker
                        titledpane_aanpassenGegevens.setVisible(false);
                    }
                });
                button_cancelGegevens.setOnMouseClicked(event1 -> {
                    if (event1.getButton() == MouseButton.PRIMARY) {
                        button_aanpassenEmail.setVisible(true);
                        button_aanpassenWachtwoord.setVisible(true);
                        button_aanpassenGebruikersnaam.setVisible(true);
                        text_aanpassenGegevens.setText("Kies wat je aan wilt passen");
                        textfield_aanpassenGegevens.setVisible(false);
                        button_bevestigenGegevens.setVisible(false);
                        button_cancelGegevens.setVisible(false);
                        titledpane_aanpassenGegevens.setVisible(false);
                    }
                });
            }
        });
        button_aanpassenEmail.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                button_aanpassenEmail.setVisible(false);
                button_aanpassenWachtwoord.setVisible(false);
                button_aanpassenGebruikersnaam.setVisible(false);
                text_aanpassenGegevens.setText("Voer uw nieuwe emailadres in");
                textfield_aanpassenGegevens.setVisible(true);
                button_bevestigenGegevens.setVisible(true);
                button_cancelGegevens.setVisible(true);
                button_bevestigenGegevens.setOnMouseClicked(event1 -> {
                    if (event1.getButton() == MouseButton.PRIMARY) {
                        //Hier moet dan komen dat textfield_aanpassengegevens het nieuwe emailadres wordt van de gebruiker
                        titledpane_aanpassenGegevens.setVisible(false);
                    }
                });
                button_cancelGegevens.setOnMouseClicked(event1 -> {
                    if (event1.getButton() == MouseButton.PRIMARY) {
                        button_aanpassenEmail.setVisible(true);
                        button_aanpassenWachtwoord.setVisible(true);
                        button_aanpassenGebruikersnaam.setVisible(true);
                        text_aanpassenGegevens.setText("Kies wat je aan wilt passen");
                        textfield_aanpassenGegevens.setVisible(false);
                        button_bevestigenGegevens.setVisible(false);
                        button_cancelGegevens.setVisible(false);
                        titledpane_aanpassenGegevens.setVisible(false);
                    }
                });
            }
        });
        button_aanpassenWachtwoord.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                button_aanpassenEmail.setVisible(false);
                button_aanpassenWachtwoord.setVisible(false);
                button_aanpassenGebruikersnaam.setVisible(false);
                text_aanpassenGegevens.setText("Voer uw nieuwe wachtwoord in");
                passwordField_aanpassenGegevens.setVisible(true);
                button_bevestigenGegevens.setVisible(true);
                button_cancelGegevens.setVisible(true);
                button_bevestigenGegevens.setOnMouseClicked(event1 -> {
                    if (event1.getButton() == MouseButton.PRIMARY) {
                        //Hier moet dan komen dat textfield_aanpassengegevens het nieuwe wachtwoord wordt van de gebruiker
                        titledpane_aanpassenGegevens.setVisible(false);
                    }
                });
                button_cancelGegevens.setOnMouseClicked(event1 -> {
                    if (event1.getButton() == MouseButton.PRIMARY) {
                        button_aanpassenEmail.setVisible(true);
                        button_aanpassenWachtwoord.setVisible(true);
                        button_aanpassenGebruikersnaam.setVisible(true);
                        text_aanpassenGegevens.setText("Kies wat je aan wilt passen");
                        textfield_aanpassenGegevens.setVisible(false);
                        button_bevestigenGegevens.setVisible(false);
                        button_cancelGegevens.setVisible(false);
                        titledpane_aanpassenGegevens.setVisible(false);
                    }
                });
            }
        });
    }
}
