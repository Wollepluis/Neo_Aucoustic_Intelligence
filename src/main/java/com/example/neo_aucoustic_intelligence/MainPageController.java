package com.example.neo_aucoustic_intelligence;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MainPageController {

    @FXML
    private Button Button_sendPrompt;

    @FXML
    private Button button_logoutDropdown;

    @FXML
    private Label label_title;

    @FXML
    private ImageView button_showSidebar;

    @FXML
    private AnchorPane sidebar;

    @FXML
    private TextField txt_promptField;

    @FXML
    void logoutDropdown(ActionEvent event) {

    }

    @FXML
    void sendPrompt(ActionEvent event) {

    }

    @FXML
    void showSidebar(MouseEvent event) {

        if (sidebar.isVisible()) {
            sidebar.setVisible(false);
            txt_promptField.setPrefWidth(680);
            label_title.setLayoutX(294);

        }
        else {
            sidebar.setVisible(true);
            txt_promptField.setPrefWidth(490);
            label_title.setLayoutX(384);
        }
    }

}
