package com.example.sceneproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ButtonController implements Initializable {
    @FXML
    private Button button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("View loaded");
    }

    @FXML
    public void handleButtonClick(ActionEvent event) {
        System.out.println("You clicked on button");
        button = (Button) event.getSource();
        System.out.println(button.getText());
        button.setText("Click again if you dare!");
        System.out.println(button.getText());
    }
}
