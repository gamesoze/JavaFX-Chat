package client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controllers {
    public static void changeScene(String fxml, ActionEvent event, Class<?> cls) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(new Scene(FXMLLoader.load(cls.getResource(fxml))));
        window.show();
    }
}
