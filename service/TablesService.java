package service;

import util.CreateTables;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TablesService {
    private Connection connection;
    private DatabaseMetaData dbm;

    public TablesService(Connection connection, DatabaseMetaData dbm) {
        this.connection = connection;
        this.dbm = dbm;
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