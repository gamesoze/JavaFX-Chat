package client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Welcome {
    @FXML
    private TextField loginFld;

    @FXML
    private TextField passwordFld;

    @FXML
    private Button loginBtn;

    @FXML
    private Hyperlink createAccountLink;

    @FXML
    private void checkLoginAndPassword(ActionEvent event) {

    }

    @FXML
    private void changeSceneToCreateNewAccount(ActionEvent event) {
        try {
            Controllers.changeScene("/view/registration.fxml", event, getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
