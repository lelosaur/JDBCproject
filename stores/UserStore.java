/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stores;

import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author daryl
 * data access layer(data layer)
 */
public class UserStore {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    //    Connection connection;
    public void createUser(User users) {

        //Review review1 = new Review(UserID,StoreID, Usersname, Storename, review);
        try {


            String sql = "INSERT INTO Users(username, userID) VALUES(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, users.getUsername());
            statement.setString(2, users.getUserID());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Insert failed in CreateUser");
            System.err.println("Message from Postgres: " + e.getMessage());
            System.exit(-1);
        }

    }

    public String getUser(String userID) {
        String userNameResult = "";

        try {
            String psql = "SELECT DISTINCT username FROM Users WHERE userID =?";
            PreparedStatement statement = connection.prepareStatement(psql);
            statement.setString(1, userID);
            ResultSet res = statement.executeQuery(); //add ResultSet to retrieve the results from the query
            while (res.next()) {
                userNameResult = res.getString(1);
            }

        } catch (SQLException e) {
            System.err.println("Query failed in UserStore.getUser");
            System.err.println("Message from Postgres: " + e.getMessage());
        }
        return userNameResult;


    }
}
