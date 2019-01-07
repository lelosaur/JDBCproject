package Driver;

import models.Restaurant;
import models.Review;
import models.User;
import module.UsernameTextFileReader;
import stores.RestaurantStore;
import stores.UserStore;
import util.CreateTables;

import java.io.File;
import java.sql.*;
import java.util.Scanner;


/**
 * @author daryl
 */
public class YelpProjectInitializer {
    public static void main(String[] args) throws Exception

    {
        //path to password
        File file = new File("C:\\Users\\daryl\\Desktop\\password.txt");
        Scanner sc = new Scanner(file);

        //path to connection
        Connection connection;
        String uname = "postgres";
        String pass = sc.next(); //"admin"
        Class.forName("org.postgresql.Driver");  //Registering the driver
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", uname, pass);  //Making the Connection
        DatabaseMetaData dbm = connection.getMetaData(); //testing with method runTables


        //delete tables
        CreateTables createtables = new CreateTables(connection);
        createtables.deleteTables();


        //create tables
        runTables(connection, dbm);


        //insert order of restaurants + users-> reviews C->AB in terms of hierarchy //later you change user/reviews to ID in the review/restaurant constructors in case user isn't created.<-in relation to
        // userservices where you're checking for existing users

        Restaurant restaurant2 = new Restaurant("restaurant2", "2");
        restaurant2.setConnection(connection);
        RestaurantStore restaurantStore = new RestaurantStore(connection);
        restaurantStore.createRestaurant(restaurant2);
        System.out.println(restaurantStore.getRestaurantName(restaurant2.getRestaurantID()));



        User user2 = new User("User2", "1");
        user2.setConnection(connection);
        UserStore userStore = new UserStore();
        userStore.setConnection(connection);
        userStore.createUser(user2);//create user

        System.out.println(userStore.getUser("1"));//query for user



        Review review2 = new Review("1", "User2", "restaurant2", "2", "is 2 gud");
        review2.setConnection(connection);
        review2.storeReview();


        //testing Usernames
        //MOVE TO UserService ASAP
        File testfile = new File("C:/Users/daryl/Desktop/tests/testfile.txt");
        //Note to self:requires Throws Exception
        UsernameTextFileReader usernameTextFileReader = new UsernameTextFileReader();
        try {
            usernameTextFileReader.testUsername(testfile, "Username3");
        } catch (Exception e) {
            e.printStackTrace();
        }
        UsernameTextFileReader usernameTextFileReader2 = new UsernameTextFileReader();
        usernameTextFileReader2.testUsername(testfile, "Username4");

        UsernameTextFileReader usernameTextFileReaderError = new UsernameTextFileReader();
        usernameTextFileReaderError.testUsername(testfile, "ErrorUsername2");


        connection.close();
    }


    public static void runTables(Connection connection, DatabaseMetaData dbm) throws SQLException {


        //instantiate createTables object and connection to start generating tables
        CreateTables createTables = new CreateTables(connection);


        // check if the tables exist. If they don't, make them
        ResultSet restaurantTables = dbm.getTables(null, null, "restaurants", null);
        if (restaurantTables.next()) { // if there is a "next" table, it exists already
            System.out.println("Table restaurants already exists!");
        } else {
            createTables.createRestaurants(connection);
        }
        ResultSet userstables = dbm.getTables(null, null, "users", null);
        if (userstables.next()) {
            System.out.println("Table users already exists!");
        } else {
            createTables.createUsers();
        }
        ResultSet reviewstables = dbm.getTables(null, null, "reviews", null);
        if (reviewstables.next()) {
            System.out.println("Table reviews already exists!");
        } else {
            createTables.createReviews();
        }

    }
}
