package com.example.demoweek5inclass;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
       // DBUtility db = new DBUtility();
        //db.getAllFoodMenu();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("foodMenuTable.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {


        launch();
    }
}