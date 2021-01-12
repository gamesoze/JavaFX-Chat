package client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Registration {
    @FXML
    private TextField loginFld;

    @FXML
    private TextField passwordFldTop;

    @FXML
    private TextField passwordFldBtm;

    @FXML
    private Button registrationBtn;

    @FXML
    private Hyperlink registrationLink;

    @FXML
    private void checkAndRegistration() {
        if (passwordFldBtm.getText().equals(passwordFldTop.getText())) {
            // connect to server
            registrationBtn.setDisable(true);
        }
    }

    @FXML
    private void changeSceneToCreateNewAccount(ActionEvent event) {
        try {
            Controllers.changeScene("/view/welcome.fxml", event, getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
