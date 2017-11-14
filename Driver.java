/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.project;
import java.sql.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author daryl
 */
public class Driver {
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
    StoreRestaurant sRestaurant = new StoreRestaurant(connection);
    UserStore uStore = new UserStore(connection);
    Tables tables = new Tables(connection);
//    tables.createStores();
//    tables.createReviews();
//    tables.createUsers();
    //UserID, Usersname, Storename, StoreID, review
    Review review = new Review(1, "User1", "store1", 1, "is gud");
    Stores store = new Stores("store1", 1);
    Users user = new Users("User1", 1);
    
    //insert to tables
    rStore.createReview(review);
    sRestaurant.createStore(store);
    uStore.createUser(user);
    
    
    //app.makeReviewTable(connection);
    connection.close();
}
}
