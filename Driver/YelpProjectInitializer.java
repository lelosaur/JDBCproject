/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;
import module.UsernameTextFileReader;
import util.CreateTables;
import stores.RestaurantStore;
import stores.ReviewStore;
import stores.UserStore;
import models.Review;
import models.YelpUser;
import models.Restaurant;
import java.sql.*;
import java.io.*;
import java.util.Scanner;

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


        // instantiate store objects, link connection, and create createTables
        ReviewStore rStore = new ReviewStore(connection);
        RestaurantStore sRestaurant = new RestaurantStore(connection);
        UserStore uStore = new UserStore(connection);
        CreateTables createTables = new CreateTables(connection);
        DatabaseMetaData dbm = connection.getMetaData();

        // check if the tables exist. If they don't, make them
        ResultSet restauranttables = dbm.getTables(null, null, "restaurants", null);
        if (restauranttables.next()) {
            //System.out.println("Table restaurants already exists!");
        }
        else {
            createTables.createRestaurants();
        }
        ResultSet reviewstables = dbm.getTables(null, null, "reviews", null);
        if (reviewstables.next()) {
            // System.out.println("Table reviews already exists!");
        }
        else {
            createTables.createReviews();
        }
        ResultSet userstables = dbm.getTables(null, null, "users", null);
        if (userstables.next()) {
            //System.out.println("Table users already exists!");
        }
        else {
            createTables.createUsers();
        }


        //Give values to objects. must be in this order due to relations and foreign keys
        Review review = new Review(1, "User1", "restaurant1", 1, "is gud");
        Restaurant store = new Restaurant("restaurant1", 1);
        Restaurant store2 = new Restaurant("restaurant2", 2);
        YelpUser user = new YelpUser("User1", 1);
        YelpUser user2 = new YelpUser("User2", 2);

        //testing Usernames
        File testfile = new File("C:\\Users\\daryl\\IdeaProjects\\YelpProject");
        UsernameTextFileReader usernameTextFileReader = new UsernameTextFileReader();
        usernameTextFileReader.testUsername("testfile.txt","Username5");
        UsernameTextFileReader usernameTextFileReader2 = new UsernameTextFileReader();
        usernameTextFileReader2.testUsername(testfile,"Username5");

        //insert to createTables
        uStore.createUser(user2);
        sRestaurant.createRestaurant(store);
        sRestaurant.createRestaurant(store2);
        uStore.createUser(user);
        rStore.createReview(review);




        connection.close();}
}
