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

public class StoreStore {
    public StoreStore(){
    
}
        public void createStore(Stores store){
            try{
            Connection connection =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "ihateryan"); 
            String sql = "INSERT INTO Stores(Storename, StoreID) VALUES(?,?)";
            //Connection connection = review.setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, store.getStore());
            statement.setInt(2, store.getStoreID());

            statement.execute();
            statement.close();
        }
        catch(SQLException e){
		System.err.println("Insert failed in createStore");
		System.err.println("Message from Postgres: " + e.getMessage());
		System.exit(-1);} 
        }
}
