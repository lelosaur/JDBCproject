/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author daryl
 */
public class CreateTables {
    private Connection connection;

    public CreateTables(Connection connection) {
        this.connection = connection;
    }

    public void createReviews() {
        try {

            //userID, usersname, storename, storeID, review
            String sql = "CREATE TABLE Reviews " +
                    "(userID VARCHAR(255) not NULL REFERENCES users(userID), " +
                    " usersname VARCHAR(255), " +
                    " restaurantname VARCHAR(255), " +
                    " restaurantID INTEGER not NULL REFERENCES restaurants(restaurantID), " +
                    "review VARCHAR(800)) ";

            PreparedStatement statement = connection.prepareStatement(sql);
            //ResultSet rs = statement.executeQuery(sql); <- this would be used to retrieve data from the database
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Insert failed in createReviews");
            System.err.println("Message from Postgres: " + e.getMessage());
            System.exit(-1);
        }

    }

    public void createUsers() {
        try {

            //usersname, userID
            String sql = "CREATE TABLE users " +
                    " ( username VARCHAR(255) NOT NULL, " +
                    " userID VARCHAR(255) not NULL, " +
                    " PRIMARY KEY ( userID ))";

            PreparedStatement statement = connection.prepareStatement(sql);
            //ResultSet rs =
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Insert failed in createUsers");
            System.err.println("Message from Postgres: " + e.getMessage());
            System.exit(-1);
        }
    }


    public void createRestaurants(Connection connection) {
        try {

            //storename, storeID
            String sql = "CREATE TABLE Restaurants " +
                    " (restaurantName VARCHAR(255), " +
                    " restaurantID INTEGER not NULL, " +
                    " PRIMARY KEY ( restaurantID ))";

            PreparedStatement statement = connection.prepareStatement(sql);
            //ResultSet rs =
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            System.err.println("Insert failed in createRestaurants");
            System.err.println("Message from Postgres: " + e.getMessage());
            System.exit(-1);
        }
    }

    public void deleteTables() {
        try {
            String sql = "DROP SCHEMA public CASCADE;\n" +
                    "CREATE SCHEMA public;";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Delete failed in deleteTables");
            System.err.println("Message from Postgres: " + e.getMessage());
            System.exit(-1);

        }
    }
}


