/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import stores.RestaurantStore;

import java.sql.Connection;

/**
 * @author daryl
 */
public class Restaurant {
    private String restaurant;
    private String restaurantID;
    private Connection connection;
    private RestaurantStore restaurantStore;


    public Restaurant(String restaurant, String restaurantID) {
        this.restaurant = restaurant;
        this.restaurantID = restaurantID;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(String restaurantID) {
        this.restaurantID = restaurantID;
    }

    public void setRestaurant() {
        this.restaurant = restaurant;
    }

    public String getRestaurant() {
        return restaurant;
    }




}
