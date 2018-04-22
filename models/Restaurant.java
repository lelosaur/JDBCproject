/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import stores.RestaurantStore;

import java.sql.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author daryl
 */
public class Restaurant {
    private String restaurant;
    private int restaurantID;
    private RestaurantStore restaurantStore; //creating a private field variable in constructor instead of the method
    //createRestaurant below so all Restaurant classes can call the create class instead of running it each time I have a new
    // restaurant.

    public Restaurant(String restaurant, int restaurantID){
        this.restaurant = restaurant;
        this.restaurantID = restaurantID;

    }

    public void setRestaurant(String restaurant){
        this.restaurant = restaurant;
    }
    public String getrestaurant(){
        return restaurant;

    }
    public void setRestaurantID(int restaurantID){
        this.restaurantID = restaurantID;
    }
    public int getRestaurantID(){
        return restaurantID;
    }

//    public void createRestaurant(Restaurant restaurant, Connection connection){
//        RestaurantStore restaurantStore = new RestaurantStore(connection);
//          restaurantStore.createRestaurant(restaurant);
//
//    }


}
