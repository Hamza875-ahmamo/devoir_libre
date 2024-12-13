module org.example.exam__blanc {
    requires javafx.controls;
    requires javafx.fxml;
    opens org.example.exam__blanc to javafx.fxml;
    opens org.example.exam__blanc.controller to javafx.fxml;
    opens org.example.exam__blanc.model to com.google.gson;

    requires java.sql;
    requires com.opencsv;
    requires com.google.gson;

    exports org.example.exam__blanc;
}