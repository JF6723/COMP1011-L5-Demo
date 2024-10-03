package com.example.demoweek5inclass;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FoodMenuTableController implements Initializable {
    @FXML
    private TableColumn<FoodMenu,Double> colCal;

    @FXML
    private TableColumn<FoodMenu, String> colName;

    @FXML
    private TableColumn<FoodMenu, Double> colPrice;

    @FXML
    private TableColumn<FoodMenu, Integer> colSpicyLevel;

    @FXML
    private TableView<FoodMenu> tableViewFoodMenu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    colName.setCellValueFactory(new PropertyValueFactory<FoodMenu,String>("foodName"));
    colPrice.setCellValueFactory(new PropertyValueFactory<FoodMenu,Double>("price"));
    colSpicyLevel.setCellValueFactory(new PropertyValueFactory<FoodMenu,Integer>("spicyLevel"));
    colCal.setCellValueFactory(new PropertyValueFactory<FoodMenu,Double>("calorie"));
    DBUtility dbUtility = new DBUtility();
        try {
            dbUtility.setCredentials();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            ArrayList<FoodMenu> foodMenus = dbUtility.getAllFoodMenu();
            tableViewFoodMenu.getItems().setAll(foodMenus);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
