package com.example.sceneproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneMain extends Application {

    private Scene scene1;
    private Scene scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        //scene 1
        Label sceneLabel1 = new Label("Hello from scene 1!");
        Button sceneButton1 = new Button("Go to scene 2");
        sceneButton1.setOnAction(event -> stage.setScene(scene2));

        //container
        VBox sceneLayout1 = new VBox(20);
        sceneLayout1.getChildren().addAll(sceneLabel1, sceneButton1);

        scene1 = new Scene(sceneLayout1, 200,200);

        //scene 2
        Label sceneLabel2 = new Label("Hello from scene 2!");
        Button sceneButton2 = new Button("Go to scene 1");
        sceneButton2.setOnAction(event -> stage.setScene(scene1));

        //container
        HBox sceneLayout2 = new HBox(50);
        sceneLayout2.setPadding(new Insets(20,20,20,20));
        sceneLayout2.getChildren().addAll(sceneLabel2, sceneButton2);

        scene2 = new Scene(sceneLayout2, 700,100);

        stage.setScene(scene1);
        stage.setTitle("Dvije scene");
        stage.show();
    }
}
