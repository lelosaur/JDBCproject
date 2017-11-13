/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author daryl
 */
package jdbc.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//utilizing as data access layer
public class ReviewStore{
    public ReviewStore(){
    
}
    Connection connection;
    public void createReview(Connection connection, Review review){
        
        //Review review1 = new Review(UserID,StoreID, Usersname, Storename, review);
        try{
           // Connection connection =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "ihateryan"); 
            String sql = "INSERT INTO reviews(userID, usersname, storename, storeID, review) VALUES(?,?,?,?,?)";
            //Connection connection = review.setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, review.getUserID());
            statement.setString(2, review.getUsername());
            statement.setString(3, review.getStorename());
            statement.setInt(4, review.getStoreID());
            statement.setString(5, review.getReview());
            statement.execute();
            statement.close();
        }
        catch(SQLException e){
		System.err.println("Insert failed in createReview");
		System.err.println("Message from Postgres: " + e.getMessage());
		System.exit(-1);}
	
    }
        
    }

//Connection connection, int UserID, int StoreID, String Usersname, String Storename,  String review
   
    


    

