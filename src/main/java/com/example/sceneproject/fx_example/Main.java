package com.example.sceneproject.fx_example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //URL url = Main.class.getResource("sample.fxml");
        URL url = Main.class.getResource("sample.fxml");
        Pane root = FXMLLoader.load(url);
        stage.setTitle("FXML");
        stage.setScene(new Scene(root));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
