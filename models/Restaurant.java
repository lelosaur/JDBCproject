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
    private int restaurantID;
    private Connection connection;


    public Restaurant(String restaurant, int restaurantID) {
        this.restaurant = restaurant;
        this.restaurantID = restaurantID;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public void setRestaurant() {
        this.restaurant = restaurant;
    }

    public String getRestaurant() {
        return restaurant;
    }




    public void createRestaurant() { //should be in userStore
        RestaurantStore restaurantStore = new RestaurantStore(this.getConnection());
        Restaurant tempRestaurant = new Restaurant(restaurant, restaurantID);
        restaurantStore.createRestaurant(tempRestaurant);

    }

}
