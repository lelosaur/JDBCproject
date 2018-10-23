/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author daryl
 */
package stores;

import models.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//utilizing as data access layer
public class ReviewStore {
    private Connection connection;

    public ReviewStore(Connection connection) {
        this.connection = connection;
    }

    public Review getReview(String id) {
        Review tempReview = new Review("1","Temporary", "Temporary", 2, "temp Review");
        try{
            String sql = "SELECT * FROM Reviews WHERE Reviews.id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, tempReview.getUsername());//uses username now, but change to userID once you convert the ID variable in User constructor to String for UUID purposes
        }
        catch(SQLException e){
            System.err.println("Insert failed in getReview");
            System.err.println("Message from Postgres: " + e.getMessage());
            System.exit(-1);
        }

        return tempReview;
    }


    public void createReview(Review review) {

        //Review review1 = new Review(UserID,StoreID, Usersname, Storename, review); <- names of variables in instantiation
        try {

            String sql = "INSERT INTO reviews(userID, usersname, restaurantname, restaurantID, review) VALUES(?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, review.getUserID());
            statement.setString(2, review.getUsername());
            statement.setString(3, review.getRestaurantName());
            statement.setInt(4, review.getRestaurantID());
            statement.setString(5, review.getReview());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Insert failed in createReview");
            System.err.println("Message from Postgres: " + e.getMessage());
            System.exit(-1);
        }

    }

}








