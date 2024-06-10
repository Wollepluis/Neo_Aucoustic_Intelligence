package com.example.neo_aucoustic_intelligence;

import Chat.Bericht;
import Chat.BerichtHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import Login.Login;
import UI.*;
import java.io.IOException;
import java.util.Scanner;

import javafx.scene.Node;
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

            //UI deel
            /*newLabel();
            txt_promptField.clear();
            newAIAnswer();*/
        }
    }

    @FXML
    void newLabel() {
        double top = 2.0;
        double laagstGeplaatsteBericht = 0;
        for (Node node : textUitvoer.getChildren()) {
            double stageHeight = SceneManager.getMainScherm().getHeight();
            AnchorPane.getTopAnchor(node);
            if (laagstGeplaatsteBericht == 0) {
                laagstGeplaatsteBericht = AnchorPane.getTopAnchor(node) + (stageHeight - AnchorPane.getTopAnchor(node) - AnchorPane.getBottomAnchor(node));
            }
            if (laagstGeplaatsteBericht < AnchorPane.getTopAnchor(node) + (stageHeight - AnchorPane.getTopAnchor(node) - AnchorPane.getBottomAnchor(node))) {
                laagstGeplaatsteBericht = AnchorPane.getTopAnchor(node) + (stageHeight - AnchorPane.getTopAnchor(node) - AnchorPane.getBottomAnchor(node));
            }
            top = 20 + laagstGeplaatsteBericht;
        }
        Label newLabel = new Label(txt_promptField.getText());
        AnchorPane.setTopAnchor(newLabel, top);
        AnchorPane.setRightAnchor(newLabel, 2.0);
        textUitvoer.getChildren().add(newLabel);
    }

    @FXML
    void newAIAnswer() {
        double top = 2.0;
        double laagstGeplaatsteBericht = 0;
        for (Node node : textUitvoer.getChildren()) {
            double stageHeight = SceneManager.getMainScherm().getHeight();
            AnchorPane.getTopAnchor(node);
            if (laagstGeplaatsteBericht == 0) {
                laagstGeplaatsteBericht = AnchorPane.getTopAnchor(node) + (stageHeight - AnchorPane.getTopAnchor(node) - AnchorPane.getBottomAnchor(node));
            }
            if (laagstGeplaatsteBericht < AnchorPane.getTopAnchor(node) + (stageHeight - AnchorPane.getTopAnchor(node) - AnchorPane.getBottomAnchor(node))) {
                laagstGeplaatsteBericht = AnchorPane.getTopAnchor(node) + (stageHeight - AnchorPane.getTopAnchor(node) - AnchorPane.getBottomAnchor(node));
            }
            top = 20 + laagstGeplaatsteBericht;
        }
        Label newLabel = new Label("Dit is een voorbeeld van een antwoord van de ai.");
        AnchorPane.setTopAnchor(newLabel, top);
        AnchorPane.setLeftAnchor(newLabel, 4.0);
        textUitvoer.getChildren().add(newLabel);
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

    public void setButtonText(Button button, String text) {
        button.setText(text);
    }
    @FXML
    void setNewChat(MouseEvent event1) {
        Button newButton = new Button("Voer onderwerp in"); //inhoud van button moet onderwerp zijn van de chat
        //newbutton.setfxid()
        //sla button op in static arraylist
        newButton.setOnAction(event -> { //hier moet komen dat de chat zichtbaar wordt op het moment dat er op de knop geduwd wordt
        });

        // Set the button's position
        double top = 10.0;
        for (Node node : sidebar_chat.getChildren()) {
            top = top + 43.0;
        }
        AnchorPane.setTopAnchor(newButton, top);
        AnchorPane.setLeftAnchor(newButton, 10.0);
        sidebar_chat.getChildren().add(newButton);
    }

    void onRightMouseClick(MouseEvent event) {
        /*zorg dat de command alleen werkt wanneer de cursor op de juiste button hovert.
        fxid buttonid
        Button button;
        // geef button ook meteen een id
        buttonid = onRightMouseButtonClick.getfxid(

        for (Button b : allebuttons) {
            if (b.getfxid().equals()) {
                String nieuweText = scanner
                setButtontext(b, nieuweText);
            }
        }

         */
    }
}