package com.example.sceneproject;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SceneFocus extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private ChoiceBox<String> fruitChoiceBox;

    //Combobox
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Voce");
        fruitChoiceBox = new ChoiceBox<>();
        ObservableList<String> observableList = fruitChoiceBox.getItems();
        observableList.add("Jabuka");
        observableList.addAll("Limun", "Jagoda", "Kivi");
        observableList.addAll("Limun", "Jagoda", "Kivi");
        observableList.addAll("Limun", "Jagoda", "Kivi");
        observableList.addAll("Limun", "Jagoda", "Kivi");
        fruitChoiceBox.setValue(observableList.get(0));
        //selection changes
        SingleSelectionModel<String> selectionModel = fruitChoiceBox.getSelectionModel();
        ReadOnlyObjectProperty<String> itemProperty = selectionModel.selectedItemProperty();
        itemProperty.addListener((observable, oldValue, newValue)->{
            System.out.println("Pojedena vocka:"+ oldValue+", treba jos pojesti :"+newValue);
        });

        Button buyButton = new Button("Kupi voce");
        buyButton.setOnAction(this::handleFruitChoice);

        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.getChildren().addAll(fruitChoiceBox, buyButton);

        Scene scene = new Scene(vBox, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

    private void handleFruitChoice(Event event) {
        String fruit = fruitChoiceBox.getValue();
        System.out.println("Voce je :"+fruit);
    }

    //Checkbox
    /*private CheckBox cevapiCheckBox;
    private CheckBox pizzaCheckBox;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Narudzba hrane");
        cevapiCheckBox = new CheckBox("Cevapi");
        pizzaCheckBox = new CheckBox("Pizza");
        //pizzaCheckBox.setSelected(true);

        Button orderButton = new Button("Naruci");
        orderButton.setOnAction(this::handleOrder);

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.getChildren().addAll(cevapiCheckBox, pizzaCheckBox, orderButton);

        Scene scene = new Scene(vBox, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

    private void handleOrder(Event event) {
        String message = "Korisnicka narudzba:"+System.lineSeparator();
        if(cevapiCheckBox.isSelected()) {
            message+="Cevapi"+System.lineSeparator();
        }
        if(pizzaCheckBox.isSelected()) {
            message+="Pizza"+System.lineSeparator();
        }
        System.out.println(message);
    }*/

    //Login form
    /*@Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("JavaFx GridPane");
        GridPane formGridPane = new GridPane();

        //spoljasni i unutarnji razmak
        formGridPane.setPadding(new Insets(10, 10, 10, 10));
        GridPane.setMargin(formGridPane, new Insets(20, 20, 20, 20));
        formGridPane.setVgap(8);
        formGridPane.setHgap(10);

        //Username ili korisnički nalog
        Label usernameLabel = new Label("Username");
        GridPane.setConstraints(usernameLabel, 0, 0);
        TextField usernameTextField = new TextField();
        usernameTextField.setPromptText("Enter username....");
        GridPane.setConstraints(usernameTextField, 1, 0);

        //Password ili lozinka
        Label passwordLabel = new Label("Password");
        GridPane.setConstraints(passwordLabel, 0, 1);
        PasswordField passwordTextField = new PasswordField();
        passwordTextField.setPromptText("Enter password..");
        GridPane.setConstraints(passwordTextField, 1, 1);

        //LOGIN button
        Button loginButton = new Button("Sign in");
        GridPane.setConstraints(loginButton, 1, 2);
        ObservableList<Node> children = formGridPane.getChildren();
        children.addAll(usernameLabel, usernameTextField, passwordLabel, passwordTextField, loginButton);
        Scene scene = new Scene(formGridPane, 300, 250);
        stage.setScene(scene);
        stage.show();
    }*/



    /*@Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Slaganje kontejnera unutar kontejnera");
        HBox topMenuBox = new HBox();
        Button fileButton = new Button("File");
        Button editButton = new Button("Edit");
        Button viewButton = new Button("View");
        topMenuBox.getChildren().addAll(fileButton, editButton, viewButton);
        VBox leftMenuBox =new VBox();
        Button fileButton1 = new Button("File");
        Button editButton1 = new Button("Edit");
        Button viewButton1 = new Button("View");
        leftMenuBox.getChildren().addAll(fileButton1, editButton1, viewButton1);
        BorderPane borderPane = new BorderPane();
        //top left center right bottom
        borderPane.setTop(topMenuBox);
        borderPane.setLeft(leftMenuBox);
        Scene scene = new Scene(borderPane, 300, 250);
        stage.setScene(scene);
        stage.show();
    }*/



    /*private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("Closing of window");
        //stage.setOnCloseRequest(this::closeProgram);
        stage.setOnCloseRequest(e->{
            //Java needs to believe us during closing app
            e.consume();
            closeProgram(e);
        });
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

    }*/



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
