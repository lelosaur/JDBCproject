/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.project;
import java.sql.*;
import java.util.*;
/**
 *
 * @author daryl
 */
public class JDBCProject {

    /**
     * @param args the command line arguments
     */
    public void createUser(Connection connection, String User, int UserID){
        try{
            String sql = "INSERT INTO UserYelp(name, UserID) VALUES(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, User);
            statement.setInt(2, UserID);
            statement.execute();
            statement.close();
        }
        catch(SQLException e){
		System.err.println("Insert failed in createUser");
		System.err.println("Message from Postgres: " + e.getMessage());
		System.exit(-1);}
	
    }
    
    public void makeUserYelp(Connection connection){
             try{
            String sql = "CREATE TABLE Useryelp " +
                   "(UserID INTEGER not NULL, " +
                   " name VARCHAR(255), " + 
                   " PRIMARY KEY ( UserID ))"; 
            
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            statement.close();
     }
      catch(SQLException e){
		System.err.println("Insert failed in createUser");
		System.err.println("Message from Postgres: " + e.getMessage());
		System.exit(-1);}
    }
    
    public void makeReviewTable(Connection connection){
        try{
            String sql = "CREATE TABLE reviews " +
                   "(UserID INTEGER not NULL REFERENCES UserID, " +
                   "Usersname VARCHAR(255), " + 
                    " Storename VARCHAR(255), " +
                    " StoreID VARCHAR(255) not NULL, " +
                    "review VARCHAR(800)); "; 
            
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            statement.close();
     }
      catch(SQLException e){
		System.err.println("Insert failed in createUser");
		System.err.println("Message from Postgres: " + e.getMessage());
		System.exit(-1);}
    }
    
//    public void insertFilmIntoInventory(Connection connection, String
//			title, String description, int length, String rating)
//	{
//		try{
//		String sql = "INSERT INTO dv_film(title, description, length, rating) VALUES(?,?,?, CAST(? AS mpaa_rating))";	
//		PreparedStatement statement = connection.prepareStatement(sql);	
//		statement.setString(1, title);
//		statement.setString(2, description);
//		statement.setInt(3, length);
//		statement.setString(4, rating);
//		statement.execute();
//		statement.close();
//		}
//		catch(SQLException e){
//		System.err.println("Query failed in insertFilmIntoInventory");
//		System.err.println("Message from Postgres: " + e.getMessage());
//		System.exit(-1);}
//	}
//    
//    /**
//	 * Return a list of phone numbers of customers, given a first name and
//	 * last name.
//	 */
//    public List<String> getCustomerPhoneFromFirstLastName(Connection connection,
//			String firstName, String lastName) {
//		List<String> result = new ArrayList<String>();
//        try{
//		
//		String sql = "SELECT d.phone FROM dv_address d, mg_customers m WHERE m.first_name = ? AND m.last_name = ? AND  m.address_id = d.address_id";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        
//        statement.setString(1, firstName);
//        statement.setString(2, lastName);
//        ResultSet res = statement.executeQuery();
//        
//        
//        while (res.next()){
//            result.add(res.getString(1));
//        }
//        
//        res.close();
//        statement.close();
//            
//        }catch (SQLException e){
//		System.err.println("Query failed in getCustomerPhoneFromFirstLastName");
//		System.err.println("Message from Postgres: " + e.getMessage());
//		System.exit(-1);}
//		return result;
//	}
    public JDBCProject(){
    
};
    
}
