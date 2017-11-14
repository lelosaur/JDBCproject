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
    private Connection connection;
    public StoreStore(Connection connection){
    this.connection = connection;
}
        public void createStore(Stores store){
            try{
            
            String sql = "INSERT INTO Stores(Storename, StoreID) VALUES(?,?)";

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
