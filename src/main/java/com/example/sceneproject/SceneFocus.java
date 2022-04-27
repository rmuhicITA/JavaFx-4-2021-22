package com.example.sceneproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SceneFocus extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /*@Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("JavaFx");
        TextField userInputTextField = new TextField();
        userInputTextField.setMaxWidth(200);
        userInputTextField.setPromptText("Unesi svoje ime...");
        Label welcomeLabel = new Label("Welcome: ");
        //Labelu ispod ćemo vezati za userInputTextField
        Label bindedLabel = new Label();
        HBox bottomeTextBox = new HBox();
        bottomeTextBox.getChildren().addAll(welcomeLabel, bindedLabel);
        bottomeTextBox.setAlignment(Pos.CENTER);
        VBox vBox = new VBox(10);
        vBox.getChildren().addAll( userInputTextField, bottomeTextBox);
        vBox.setAlignment(Pos.CENTER);
        StringProperty bindedLabelProperty = bindedLabel.textProperty();
        StringProperty userInputTextFieldProperty = userInputTextField.textProperty();
        bindedLabelProperty.bind(userInputTextFieldProperty);
        Scene scene = new Scene(vBox, 300, 300);
        stage.setScene(scene);
        stage.show();
    }*/

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("JavaFx");
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setAlignment(Pos.CENTER);
        //Username
        Label usernameLabel = new Label("Username");
        usernameLabel.setStyle("-fx-text-fill:white;");
        //0 kolona 0 red
        GridPane.setConstraints(usernameLabel, 0, 0);
        //1 kolona 0 red
        TextField usernameField = new TextField();
        usernameField.setPromptText("Unesi username....");
        GridPane.setConstraints(usernameField, 1, 0);
        //Password
        Label passwordLabel = new Label("Password");
        passwordLabel.setId("bold-label");
        GridPane.setConstraints(passwordLabel, 0, 1);
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Unesi lozinku..");
        GridPane.setConstraints(passwordField, 1, 1);
        //Login
        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> setUserAgentStylesheet(STYLESHEET_CASPIAN));
        Button registerButton = new Button("Register");
        registerButton.getStyleClass().add("button-blue");
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER_RIGHT);
        flowPane.setHgap(20);
        flowPane.getChildren().addAll(loginButton, registerButton);
        GridPane.setConstraints(flowPane, 1, 2);
        gridPane.getChildren().addAll(usernameField, usernameLabel, passwordField, passwordLabel, flowPane);
        Scene scene = new Scene(gridPane, 600, 300);
        //scene.getStylesheets().add("Dark.css");
        scene.getStylesheets().add(SceneFocus.class.getResource("Dark.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    /*private BorderPane borderPane;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("JavaFx MenuBar");
        borderPane = new BorderPane();

        //Menu: File
        //Menu fileMenu = new Menu("File");
        //_ like there is Mnemonic added, alt+f can open menu
        Menu fileMenu = new Menu("_File");
        ObservableList<MenuItem> menuItems = fileMenu.getItems();
        MenuItem newProject = new MenuItem("New Project");
        newProject.setOnAction(event -> {
            System.out.println("New project has just been created!");
        });
        menuItems.add(newProject);
        menuItems.add(new MenuItem("Open Project"));
        menuItems.add(new MenuItem("Close Project"));
        menuItems.add(new SeparatorMenuItem());
        menuItems.add(new MenuItem("Settings"));
        menuItems.add(new MenuItem("Project structure"));
        menuItems.add(new SeparatorMenuItem());
        menuItems.add(new MenuItem("Exit"));

        //EDIT menu
        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));
        MenuItem pasteMenuItem = new MenuItem("Paste");
        pasteMenuItem.setDisable(true);
        editMenu.getItems().add(pasteMenuItem);

        //Help menu
        Menu helpMenu = new Menu("_Help");
        CheckMenuItem showLineNumbers = new CheckMenuItem("Show line numbers");
        showLineNumbers.setOnAction(event -> {
            if(showLineNumbers.isSelected()){
                System.out.println("Program će prikazati brojeve linija..");
            }else{
                System.out.println("Program će sakriti brojeve linija...");
            }
        });
        helpMenu.getItems().add(showLineNumbers);

        //Level menu
        Menu levelMenu = new Menu("_Level");
        RadioMenuItem easyRadioMenuItem = new RadioMenuItem("Easy");
        RadioMenuItem mediumRadioMenuItem = new RadioMenuItem("Medium");
        RadioMenuItem hardRadioMenuItem = new RadioMenuItem("Hard");
        ToggleGroup toggleGroup = new ToggleGroup();
        easyRadioMenuItem.setToggleGroup(toggleGroup);
        mediumRadioMenuItem.setToggleGroup(toggleGroup);
        hardRadioMenuItem.setToggleGroup(toggleGroup);
        levelMenu.getItems().addAll(easyRadioMenuItem, mediumRadioMenuItem, hardRadioMenuItem);

        //Menu bar
        MenuBar menuBar = new MenuBar();
        ObservableList<Menu> menus = menuBar.getMenus();
        menus.addAll(fileMenu, editMenu, helpMenu, levelMenu);

        borderPane.setTop(menuBar);
        Scene scene = new Scene(borderPane, 300, 300);
        stage.setScene(scene);
        stage.show();
    }*/

    /*private TableView<Show> showTableView;
    private TextField showTitleField;
    private TextField numOfSeasonsField;
    private TextField initialYearField;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Show table in JavaFX");

        //TABELA
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

        //FORMA
        showTitleField = new TextField();
        showTitleField.setPromptText("Enter show title...");
        numOfSeasonsField = new TextField();
        numOfSeasonsField.setPromptText("Enter num of seasons field...");
        initialYearField = new TextField();
        initialYearField.setPromptText("Enter initial field...");
        Button addShowButton = new Button("Add show");
        addShowButton.setOnAction(this::onAddShowButtonClick);
        Button deleteShowButton = new Button("Delete");
        deleteShowButton.setOnAction(this::onDeleteShowButtonClick);
        HBox forma = new HBox(10);
        forma.getChildren().addAll(showTitleField, numOfSeasonsField, initialYearField, addShowButton,deleteShowButton);
        forma.setPadding(new Insets(10,10,10,10));

        VBox vBox = new VBox();
        vBox.getChildren().addAll(showTableView, forma);

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    private void onAddShowButtonClick(Event event){
        //INSERT U BAZU
        try {
            ConnectionPool connectionPool = new ConnectionPool();
            ShowDao showDao = new ShowDao(connectionPool);
            Show show = new Show();
            show.setShowTitle(showTitleField.getText());
            show.setNumOfSeasons(Integer.parseInt(numOfSeasonsField.getText()));
            show.setInitialYear(Integer.parseInt(initialYearField.getText()));
            show = showDao.create(show);//sva osim showId
            //INSERT U TABELU
            showTableView.getItems().add(show);
            showTitleField.clear();
            numOfSeasonsField.clear();
            initialYearField.clear();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private void onDeleteShowButtonClick(ActionEvent event) {
        ObservableList<Show> selectedShows = showTableView.getSelectionModel().getSelectedItems();
        ObservableList<Show> allShows= showTableView.getItems();
        try{
            ConnectionPool connectionPool = new ConnectionPool();
            ShowDao showDao = new ShowDao(connectionPool);
            for(Show show : selectedShows){
                showDao.delete(show);
            }
        }catch (SQLException exception){
            System.err.println(exception.getMessage());
        }
        selectedShows.forEach(allShows::remove);
    }*/

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
