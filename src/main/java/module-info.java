module com.example.sceneproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sceneproject to javafx.fxml;
    exports com.example.sceneproject;
}