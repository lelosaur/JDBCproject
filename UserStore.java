/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author daryl
 */
public class UserStore {
    public UserStore(){
    }
    Connection connection;
    public void createUser(Users users){
        
        //Review review1 = new Review(UserID,StoreID, Usersname, Storename, review);
        try{
            Connection connection =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "ihateryan"); 
            
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
