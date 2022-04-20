module com.example.sceneproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.sceneproject to javafx.fxml;
    opens com.example.sceneproject.model to javafx.fxml;
    exports com.example.sceneproject;
    exports com.example.sceneproject.model;
}