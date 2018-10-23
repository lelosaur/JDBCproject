/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stores;

import models.Restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author daryl
 */

public class RestaurantStore {//handles jdbc psql logic for DB interaction
    private Connection connection;

    public RestaurantStore(Connection connection) {
        this.connection = connection;
    }

    public void getRestaurauntOwner(){

    }


    public void createRestaurant(Restaurant restaurant) {
        try {

            String sql = "INSERT INTO Restaurants(restaurantName, restaurantID) VALUES(?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, restaurant.getRestaurant());
            statement.setInt(2, restaurant.getRestaurantID());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Insert failed in createRestaurant");
            System.err.println("Message from Postgres: " + e.getMessage());
            System.exit(-1);
        }
    }
}
