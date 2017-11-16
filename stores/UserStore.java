/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stores;

import models.YelpUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author daryl
 */
public class UserStore {
    private Connection connection;
    public UserStore(Connection connection){
        this.connection = connection;
    }
//    Connection connection;
    public void createUser(YelpUser users){
        
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
