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
    public static void main(String[] args) throws Exception
//            ClassNotFoundException, FileNotFoundException, IOException,
//            SQLException
    {

        File file = new File("C:\\Users\\daryl\\Desktop\\password.txt");
        Scanner sc = new Scanner(file);

        Connection connection;
        String uname = "postgres";
        String pass = sc.next(); //"admin"
        Class.forName("org.postgresql.Driver");  //Registering the driver
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", uname, pass);  //Making the Connection
        DatabaseMetaData dbm = connection.getMetaData(); //testing with method runTables



        //delete tables THIS IS NEW STUFF RIGHT HERE <--------------
        CreateTables createtables = new CreateTables(connection);
        createtables.deleteTables();



        //create table
        runTables(connection, dbm);

        //Give values to objects. must be in this order due to relations and foreign keys


        //testing Usernames
        File testfile = new File("C:/Users/daryl/Desktop/tests/testfile.txt");
        //Note to self:requires Throws Exception
        UsernameTextFileReader usernameTextFileReader = new UsernameTextFileReader();
        try {
            usernameTextFileReader.testUsername(testfile,"Username3");
        } catch (Exception e) {
            e.printStackTrace();
        }
        UsernameTextFileReader usernameTextFileReader2 = new UsernameTextFileReader();
        usernameTextFileReader2.testUsername(testfile,"Username4");

        UsernameTextFileReader usernameTextFileReaderError = new UsernameTextFileReader();
        usernameTextFileReaderError.testUsername(testfile, "ErrorUsername2");






        connection.close();
    }

        public static void insertTest(Connection connection) {

            //it's better to put the create method from createUser/Review/Restaurant as a linked method in the
            // Restaurant, Review, and YelpUser models
            Review review = new Review(1, "User1", "restaurant1", 1, "is gud");
            Restaurant store = new Restaurant("restaurant1", 1);
            Restaurant store2 = new Restaurant("restaurant2", 2);
            YelpUser user = new YelpUser("User1", 1);
            YelpUser user2 = new YelpUser("User2", 2);
            //insert to createTables

            // instantiate store objects, link connection,
            ReviewStore rStore = new ReviewStore(connection);
            RestaurantStore sRestaurant = new RestaurantStore(connection);
            UserStore uStore = new UserStore(connection);

            uStore.createUser(user2);
            sRestaurant.createRestaurant(store);
            sRestaurant.createRestaurant(store2);
            uStore.createUser(user);
            rStore.createReview(review);
        }

        public static void runTables(Connection connection, DatabaseMetaData dbm) throws SQLException {


            //instantiate createTables object and connection to start generating tables
            CreateTables createTables = new CreateTables(connection);
            //dbm = connection.getMetaData(); //testing with method createtables


            // check if the tables exist. If they don't, make them
            ResultSet restauranttables = dbm.getTables(null, null, "restaurants", null);
            if (restauranttables.next()) { // if there is a "next" table, it exists already
                System.out.println("Table restaurants already exists!");
            }
            else {
                createTables.createRestaurants(connection);
            }
            ResultSet userstables = dbm.getTables(null, null, "users", null);
            if (userstables.next()) {
                System.out.println("Table users already exists!");
            }
            else {
                createTables.createUsers();
            }
            ResultSet reviewstables = dbm.getTables(null, null, "reviews", null);
            if (reviewstables.next()) {
                System.out.println("Table reviews already exists!");
            }
            else {
                createTables.createReviews();
            }

        }
}
