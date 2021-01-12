package client.controllers;

import client.inet.Sockets;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import server.packet.Response;

import java.io.IOException;

public class Registration {
    @FXML
    private TextField loginFld, passwordFldTop, passwordFldBtm;

    @FXML
    private Button registrationBtn;

    @FXML
    private Hyperlink registrationLink;

    @FXML
    private void checkAndRegistration() {
        if (passwordFldBtm.getText().equals(passwordFldTop.getText()) && !passwordFldBtm.getText().equals("")) {
            // connect to server
            new Thread(() -> {
                // disable button
                registrationBtn.setDisable(true);

                Sockets.sendPacketToServer(
                        new server.packet.Registration(loginFld.getText(), passwordFldBtm.getText()));

                switch ((Response) Sockets.waitPacketFromServer()) {
                    case OK:
                        // new window
                        break;
                    case BAD:
                        // bad answer
                        break;
                    case ALREADY_EXIST:
                        // person with login&pass already exist
                        break;
                }

            }).start();
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
