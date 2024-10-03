module com.example.demoweek5inclass {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.demoweek5inclass to javafx.fxml;
    exports com.example.demoweek5inclass;
}