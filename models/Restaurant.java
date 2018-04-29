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
    //private RestaurantStore restaurantStoreinternal; //creating a private field variable in constructor instead of the method
    //createRestaurant below so all Restaurant classes can call the create class instead of running it each time I have a new
    // restaurant.
    private Connection connection;


    public Restaurant(Connection connection){ //add Connection variable? what needs to happen is I need to remove
        //the restaurant and ID variables in order to allow creatRestaurant to take in variables and only have to instantiate
        //one Restaurant object
        this.connection = connection;
        //this.restaurantObj = Restaurant(restaurant, restaurantID);
    }

    public void setConnection(Connection connection){
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setRestaurantID(int restaurantID){
        this.restaurantID = restaurantID;
    }
    public int getRestaurantID(){
        return restaurantID;
    }

    public void createRestaurant(String restaurant, Integer restaurantID){
        RestaurantStore restaurantStore = new RestaurantStore(connection);
        restaurantStore.createRestaurant(restaurant, restaurantID);
    }




}
