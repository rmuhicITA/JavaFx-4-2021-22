package com.example.sceneproject;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxButton extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //Login
    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new VBox();
        AnchorPane anchorPane = FXMLLoader.<AnchorPane>load(getClass().getResource("/com/example/sceneproject/Login.fxml"));
        vBox.getChildren().addAll(anchorPane);
        //vBox.setStyle("-fx-background-color: red;");
        vBox.getStylesheets().add(getClass().getResource("/com/example/sceneproject/mystyle.css").toURI().toString());
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    //Simple button
    /*@Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new VBox();
        Button button = FXMLLoader.<Button>load(getClass().getResource("/com/example/sceneproject/Button.fxml"));
        vBox.getChildren().addAll(button);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }*/

    /*Button button;
    Label label = new Label("Pressed!");
    StackPane root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //create Scene Graph
        button = new Button("Press me!");
        root = new StackPane(button);
        Scene scene = new Scene(root, 300, 250);
        //Create Window
        primaryStage.setTitle("Button Example App");
        primaryStage.setScene(scene);
        primaryStage.show();
        //Define Button Action
        button.setOnAction(event -> {
            performAsynchronousTask();
        });
    }
    private void performAsynchronousTask() {

        Service<String> service = new Service<>() {
            @Override
            protected Task<String> createTask() {
                return new Task<>() {
                    @Override
                    protected String call() throws Exception {
                        updateProgress(0, 5);
                        for (int i = 1; i <= 5; i++) {
                            Thread.sleep(1000);
                            updateProgress(i, 5);
                        }
                        return "Complete!";
                    }
                };
            }
        };
        button.textProperty().bind(
                Bindings.concat("Progress: ", service.progressProperty().multiply(100), " %")
        );
        service.setOnSucceeded(event -> {
            button.textProperty().unbind();
            updateLabelComplete();
        });
        service.start();
    }
    private void updateLabelComplete(){
        button.setVisible(false);
        label.setText("Complete!");
        root.getChildren().setAll(label);
    }*/

}
