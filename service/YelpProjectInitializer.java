/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import util.Tables;
import stores.RestaurantStore;
import stores.ReviewStore;
import stores.UserStore;
import models.Review;
import models.YelpUser;
import models.Restaurant;
import java.sql.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author daryl
 */
public class YelpProjectInitializer {
  public static void main(String[] args) throws
        ClassNotFoundException, FileNotFoundException, IOException,
        SQLException {
       Connection connection;
       String uname = "postgres";
       String pass = "admin";
   	Class.forName("org.postgresql.Driver");  //Registering the driver
    connection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/postgres", uname, pass);  //Making the Connection 
    

    //create JDBC object(user/useryelp)
    //create review1 object instance
    //Review review1 = new Review(1234, 123,"User1","Store1", "review1");
    //create reviewStore instance
    ReviewStore rStore = new ReviewStore(connection);
    RestaurantStore sRestaurant = new RestaurantStore(connection);
    UserStore uStore = new UserStore(connection);
    Tables tables = new Tables(connection);
    tables.createRestaurants();
    tables.createUsers();
    tables.createReviews();
  
   
    Review review = new Review(1, "User1", "restaurant1", 1, "is gud");
    Restaurant store = new Restaurant("restaurant1", 1);
    Restaurant store2 = new Restaurant("restaurant2", 2);
    YelpUser user = new YelpUser("User1", 1);
    
    //insert to tables    
    sRestaurant.createRestaurant(store);
    sRestaurant.createRestaurant(store2);
    uStore.createUser(user);
    rStore.createReview(review);

    
    
    
    connection.close();}
}
