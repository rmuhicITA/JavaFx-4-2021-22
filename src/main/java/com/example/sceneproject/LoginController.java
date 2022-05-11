package com.example.sceneproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    TextField username;

    /*@FXML
    TextField password;*/
    @FXML
    PasswordField password;

    @FXML
    public void login(ActionEvent event) {
        System.out.println("You entered " + username.getText() + " " + password.getText());
    }
}
