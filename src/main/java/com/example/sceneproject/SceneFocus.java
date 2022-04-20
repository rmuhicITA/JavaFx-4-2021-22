package com.example.sceneproject;

import com.example.sceneproject.controller.ShowController;
import com.example.sceneproject.model.Person;
import com.example.sceneproject.model.Show;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SceneFocus extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    TableView<Show> showTableView;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Show table in JavaFX");

        TableColumn<Show, Integer> showIdColumn = new TableColumn<>("Show ID");
        showIdColumn.setCellValueFactory(new PropertyValueFactory<>("showId"));

        TableColumn<Show, String> showTitleColumn = new TableColumn<>("Show Title");
        showTitleColumn.setCellValueFactory(new PropertyValueFactory<>("showTitle"));

        TableColumn<Show, Integer> showNumOfSeasonsColumn = new TableColumn<>("Show number of seasons");
        showNumOfSeasonsColumn.setCellValueFactory(new PropertyValueFactory<>("numOfSeasons"));

        TableColumn<Show, Integer> showInitialYearColumn = new TableColumn<>("Show initial year");
        showInitialYearColumn.setCellValueFactory(new PropertyValueFactory<>("initialYear"));

        showTableView = new TableView<>();
        showTableView.getItems().addAll(new ShowController().loadShows());
        showTableView.getColumns().addAll(showIdColumn, showTitleColumn, showNumOfSeasonsColumn, showInitialYearColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(showTableView);

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    /*private TreeView<String> treeView;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tree view");
        treeView = new TreeView<>();
        TreeItem<String> rootItem = new TreeItem<>("Programski jezici");
        rootItem.setExpanded(true);
        TreeItem<String> javaBranch = createBranch("Java", rootItem);
        createBranch("Ruby", javaBranch);
        createBranch("Scala", javaBranch);
        createBranch("Kotlin", javaBranch);
        TreeItem<String> javascriptBranch = createBranch("JavaScript", rootItem);
        createBranch("React", javascriptBranch);
        createBranch("Vue", javascriptBranch);
        createBranch("Angular", javascriptBranch);

        treeView = new TreeView<>(rootItem);
        MultipleSelectionModel<TreeItem<String>> selectionModel = treeView.getSelectionModel();
        ReadOnlyObjectProperty<TreeItem<String>> readOnlyObjectProperty = selectionModel.selectedItemProperty();
        readOnlyObjectProperty.addListener((observable, oldValue, newValue)->{
            if(newValue!= null ) {
                System.out.println(newValue.getValue());
            }
        });

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(treeView);

        Scene scene = new Scene(stackPane, 300, 300);
        stage.setScene(scene);
        stage.show();
    }

    private TreeItem<String> createBranch(String title, TreeItem<String> parent) {
        TreeItem<String> branchItem = new TreeItem<>(title);
        branchItem.setExpanded(true);
        parent.getChildren().add(branchItem);
        return branchItem;
    }*/



    /*private ListView<Person> personView;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Lista java fx");

        personView = new ListView<>();
        ObservableList<Person> personObservableList = personView.getItems();
        personObservableList.add(new Person("Imenic1","Prezimenic1"));
        personObservableList.add(new Person("Imenic2","Prezimenic2"));
        personObservableList.add(new Person("Imenic3","Prezimenic3"));
        personObservableList.add(new Person("Imenic4","Prezimenic4"));
        personObservableList.add(new Person("Imenic5","Prezimenic5"));
        personObservableList.add(new Person("Imenic6","Prezimenic6"));
        personObservableList.add(new Person("Imenic7","Prezimenic7"));
        personObservableList.add(new Person("Imenic8","Prezimenic8"));
        personObservableList.add(new Person("Imenic9","Prezimenic9"));
        MultipleSelectionModel<Person> selectionModel = personView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);

        Button choosePersonBtn = new Button("Odaberi osobu");
        choosePersonBtn.setOnAction(this::favouritePersonSelect);

        VBox vBox = new VBox(10);
        ObservableList<Node> children = vBox.getChildren();
        children.addAll(personView, choosePersonBtn);

        Scene scene = new Scene(vBox, 300,250);
        stage.setScene(scene);
        stage.show();
    }

    private void favouritePersonSelect(ActionEvent e) {
        StringBuilder sb = new StringBuilder();
        sb.append("Omiljene osobe:");
        sb.append(System.lineSeparator());
        ObservableList<Person> selectedPersons = personView.getSelectionModel().getSelectedItems();
        for(Person person : selectedPersons) {
            sb.append(person.toString());
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }*/

    /*private ComboBox<String> moviesComboBox;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Movie java fx");
        moviesComboBox = new ComboBox<>();
        ObservableList<String> movieList = moviesComboBox.getItems();
        movieList.addAll("Joker", "Godfather","Batman", "Superman","Star Wars");
        moviesComboBox.setPromptText("Odaberi film..");
        moviesComboBox.setEditable(true);
        moviesComboBox.setOnAction(this::onChooseMovieHandler);

        Button chooseButton = new Button("Odaberi");
        chooseButton.setOnAction(this::onChooseMovieHandler);

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().addAll(moviesComboBox, chooseButton);

        Scene scene = new Scene(vBox, 300,250);
        stage.setScene(scene);
        stage.show();
    }

    private void onChooseMovieHandler(Event event) {
        System.out.println("Omiljeni film:"+moviesComboBox.getValue());
    }*/

    /*private ChoiceBox<String> fruitChoiceBox;

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
    }*/

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
