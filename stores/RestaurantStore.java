/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stores;

import models.Restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author daryl
 */

public class RestaurantStore {//handles jdbc psql logic for DB interaction
    private Connection connection;

    public RestaurantStore(Connection connection) {
        this.connection = connection;
    }

    public String getRestaurantName(String restaurantID) {
        String restaurantName = "";

        try {
            String psql = "SELECT DISTINCT restaurantName FROM Restaurants WHERE restaurantID =?";
            PreparedStatement statement = connection.prepareStatement(psql);
            statement.setString(1, restaurantID);
            ResultSet res = statement.executeQuery(); //add ResultSet to retrieve the results from the query
            while (res.next()) {
                restaurantName = res.getString(1);
            }

        } catch (SQLException e) {
            System.err.println("Query failed in RestaurantStore.getRestaurantName");
            System.err.println("Message from Postgres: " + e.getMessage());
        }
        return restaurantName;


    }


    public void createRestaurant(Restaurant restaurant) {
        try {

            String sql = "INSERT INTO Restaurants(restaurantName, restaurantID) VALUES(?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, restaurant.getRestaurant());
            statement.setString(2, restaurant.getRestaurantID());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Insert failed in createRestaurant");
            System.err.println("Message from Postgres: " + e.getMessage());
            System.exit(-1);
        }
    }
}
