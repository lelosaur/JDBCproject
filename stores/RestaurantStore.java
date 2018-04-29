/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stores;

import models.Restaurant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author daryl
 */

public class RestaurantStore {
    private Connection connection;
    public RestaurantStore(Connection connection){
        this.connection = connection;
    }
    public void createRestaurant(String restaurant, Integer restaurantID){
        try{

            String sql = "INSERT INTO Restaurants(restaurantName, restaurantID) VALUES(?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, restaurant);
            statement.setInt(2, restaurantID);

            statement.execute();
            statement.close();
        }
        catch(SQLException e){
            System.err.println("Insert failed in createRestaurant");
            System.err.println("Message from Postgres: " + e.getMessage());
            System.exit(-1);}
    }
}
