/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author daryl
 */
public class Tables {
 private Connection connection;
    public Tables(Connection connection){
        this.connection=connection;
    }

    public void createReviews(){
        try{
    
            //userID, usersname, storename, storeID, review
            String sql = "CREATE TABLE Reviews " +
                   "(userID INTEGER not NULL, " +
                   "storeID VARCHAR(255) not NULL, " +
                   " usersname VARCHAR(255), " + 
                   " storename VARCHAR(255), " +
                   " storeID VARCHAR(255) not NULL, " +
                   "review VARCHAR(800)) ";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            //ResultSet rs = 
            statement.execute();
            statement.close();
        }
        catch(SQLException e){
		System.err.println("Insert failed in createReviews");
		System.err.println("Message from Postgres: " + e.getMessage());
		System.exit(-1);
        }
	
    }

    public void createUsers(){
            try{
   
            //usersname, userID
            String sql = "CREATE TABLE users " +
                   " ( username VARCHAR(255), " +
                   " userID INTEGER not NULL, " +
                   " PRIMARY KEY ( userID ))"; 
            
            PreparedStatement statement = connection.prepareStatement(sql);
            //ResultSet rs = 
            statement.execute();
            statement.close();
        }
        catch(SQLException e){
		System.err.println("Insert failed in createUsers");
		System.err.println("Message from Postgres: " + e.getMessage());
		System.exit(-1);
        }
    }
    

    public void createStores(){
        try{
            
            //storename, storeID
            String sql = "CREATE TABLE Stores " +
                   " (storeName VARCHAR(255), " +
                   " storeID INTEGER not NULL, " +
                   " PRIMARY KEY ( storeID ))"; 
            
            PreparedStatement statement = connection.prepareStatement(sql);
            //ResultSet rs = 
            statement.execute();
            statement.close();
            
        }
        catch(SQLException e){
		System.err.println("Insert failed in createStores");
		System.err.println("Message from Postgres: " + e.getMessage());
		System.exit(-1);
        }
    }
  }  

