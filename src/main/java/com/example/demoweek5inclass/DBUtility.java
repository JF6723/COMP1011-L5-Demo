package com.example.demoweek5inclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DBUtility {
    private String user="student";
    private String password="student";
    private String url="jdbc:mysql://127.0.0.1:3306/foodmenu2023";

    public void setCredentials() throws IOException {
        FileInputStream fis = new FileInputStream("src/main/resources/com/example/demoweek5inclass/db.config");
        Properties prop = new Properties();
        prop.load(fis);

        user=prop.getProperty("username");
        password=prop.getProperty("password");

    }

    public ArrayList<FoodMenu> getAllFoodMenu() throws SQLException {

        ArrayList<FoodMenu> foodMenus = new ArrayList<>();
        String query = "select * from foodmenu";

        try(Connection conn= DriverManager.getConnection(url,user,password);
            Statement stmt=conn.createStatement();
            ResultSet resultSet=stmt.executeQuery(query);) {

            while (resultSet.next()) {
                String menu_name = resultSet.getString("name");
                double menu_price = resultSet.getDouble("price");
                int menu_spicylevel = resultSet.getInt("spicylevel");


                FoodMenu foodMenu = new FoodMenu(menu_name, menu_price, menu_spicylevel);
                foodMenus.add(foodMenu);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return foodMenus;
    }

}
