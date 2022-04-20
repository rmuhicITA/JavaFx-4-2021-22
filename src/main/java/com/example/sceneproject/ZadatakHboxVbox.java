package com.example.sceneproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ZadatakHboxVbox extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button main_menu = new Button("Main menu");
        Button start_game = new Button("Start game");
        Button exit_program = new Button("Exit program");

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(main_menu, start_game, exit_program);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setPrefSize(500,100);
        HBox.setMargin(main_menu, new Insets(20,0,20,10));
        hBox.setBackground(new Background(new BackgroundFill(Color.YELLOW, null,null)));

        HBox hBox1 = new HBox();
        hBox1.setPrefSize(500,500);
        hBox1.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox, hBox1);

        Scene scene = new Scene(vBox, 500,500);
        stage.setScene(scene);
        stage.show();
    }
}
