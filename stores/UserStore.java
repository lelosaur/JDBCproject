/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stores;

import models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author daryl
 * data access layer(data layer)
 */
public class UserStore {
    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public Connection getConnection(){
        return connection;
    }

    //    Connection connection;
    public void createUser(User users){

        //Review review1 = new Review(UserID,StoreID, Usersname, Storename, review);
        try{


            String sql = "INSERT INTO Users(username, userID) VALUES(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, users.getUsername());
            statement.setInt(2, users.getUserID());

            statement.execute();
            statement.close();
        }
        catch(SQLException e){
            System.err.println("Insert failed in CreateReview");
            System.err.println("Message from Postgres: " + e.getMessage());
            System.exit(-1);}

    }
}
