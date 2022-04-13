package com.example.sceneproject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MessageDialog {

    private String title;
    private String message;

    public MessageDialog(String t, String m) {
        this.title = t;
        this.message = m;
    }

    public void show(){
        //kreiranje stage-a
        Stage stage = new Stage();

        //event prima
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinWidth(300);
        stage.setMinHeight(200);

        Label label = new Label(message);
        Button button = new Button("OK");
        button.setOnAction(e->stage.close());
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.getChildren().addAll(label, button);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
}
