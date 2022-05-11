package com.example.sceneproject.fx_example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField usernameInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private void login(ActionEvent event) throws IOException {
        if (usernameInput.getText().equals("emir.puska") && passwordInput.getText().equals("1234")) {
            URL mainUrl = Controller.class.getResource("main.fxml");
            Parent parent = FXMLLoader.load(mainUrl);
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Main");
            stage.initStyle(StageStyle.UTILITY);
            stage.setScene(scene);
            stage.show();

        } else {
            loginMessageLabel.setText("Korisnički nalog nije ispravan");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Učitamo korisničke podatke...");
    }
}
