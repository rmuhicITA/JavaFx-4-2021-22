package com.example.sceneproject;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SceneFocus extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("Closing of window");
        stage.setOnCloseRequest(this::closeProgram);
        Button button = new Button("Close app");
        //button.setOnAction(e->closeProgram());
        //EventHandler<ActionEvent> handler = this::closeProgram;
        button.setOnAction(this::closeProgram);
        StackPane stackPane = new StackPane();
        ObservableList<Node> children = stackPane.getChildren();
        children.add(button);

        Scene scene = new Scene(stackPane, 300,250);
        stage.setScene(scene);
        stage.show();
    }

    private void closeProgram(Event event) {
        ConfirmationDialog confirmationDialog = new ConfirmationDialog("User confirmation", "Operation is in progress");
        boolean answer = confirmationDialog.show();
        if(answer)
        {
            System.out.println("File is saved...");
            stage.close();
        }else{
            System.out.println("File isn't saved...");
        }

    }



   /* @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Main window");
        Button button = new Button("Accept license agreement!");
        EventHandler<ActionEvent> eventHandler = (e) -> {
            String title = "Licence agreement";
            String message = "Please accept license agreement. New Additional text.";
            *//*ConfirmationDialog confirmationDialog = new ConfirmationDialog(title, message);
            confirmationDialog.show();*//*
            boolean answer = new ConfirmationDialog(title, message).show();
            if(answer)
                System.out.println("Agreements accepted");
                //new MessageDialog("Info", "Agreements accepted");
                //new MessageDialog("Info", "Agreements accepted").show();
            else
                System.out.println("Not accepted");
                //new MessageDialog("Info", "Not accepted").show();
        };
        button.setOnAction(eventHandler);

        StackPane stackPane = new StackPane();
        ObservableList<Node> children = stackPane.getChildren();
        children.add(button);

        Scene scene = new Scene(stackPane, 300,250);
        stage.setScene(scene);
        stage.show();
    }*/

    /*@Override
    public void start(Stage stage) {
        stage.setScene(new Scene(new Label("Demo")));
        stage.show();

        Stage inner = new Stage() {{
            setScene(new Scene(new Label("Inner")));
        }};
        inner.show();// Try replacing with showAndWait
        //inner.showAndWait();

        System.out.println("Done");
    }*/


    /*@Override
    public void start(Stage stage) throws Exception {
        Button button = new Button("otvori message stage");
        String title = "Message info";
        String message = "Sample message";
        button.setOnAction(e->new MessageDialog(title,message).show());

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);

        Scene scene = new Scene(stackPane, 300,250);
        stage.setScene(scene);
        stage.setTitle("Glavni stage");
        stage.initStyle(StageStyle.DECORATED);
        //stage.setFullScreen(true);
        stage.show();
    }*/
}
