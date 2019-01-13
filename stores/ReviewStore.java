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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//utilizing as data access layer
public class ReviewStore {
    private Connection connection;

    public ReviewStore(Connection connection) {
        this.connection = connection;
    }

    public Review getReview(String id) {//use userStore getUserName as example
        Review tempReview = new Review("1", "Temporary", "Temporary", "2", "temp Review");
        try {
            String sql = "SELECT * FROM Reviews WHERE Reviews.restaurantID = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, tempReview.getUsername());//uses username now, but change to userID once you convert the ID variable in User constructor to String for UUID purposes
        } catch (SQLException e) {
            System.err.println("Insert failed in getReview");
            System.err.println("Message from Postgres: " + e.getMessage());
            System.exit(-1);
        }

        return tempReview;
    }

    public List<String> getAllReviews(String storeID) {
        List<String> Reviews = new ArrayList<>();

        try {
            String psql = "SELECT * FROM Reviews WHERE Reviews.restaurantID = ?";
            PreparedStatement statement = connection.prepareStatement(psql);
            statement.setString(1, storeID);
            ResultSet res = statement.executeQuery(); //add ResultSet to retrieve the results from the query
            while (res.next()) {
                Reviews.add(res.getString(1));
            }
        } catch (SQLException e) {
            System.err.println("Query failed in ReviewStore.getAllReviews");
            System.err.println("Message from Postgres: " + e.getMessage());
        }
        return Reviews;

    }


    public void createReview(Review review) {

        //Review review1 = new Review(UserID,StoreID, Usersname, Storename, review); <- names of variables in instantiation
        try {

            String sql = "INSERT INTO reviews(userID, usersname, restaurantname, restaurantID, review) VALUES(?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, review.getUserID());
            statement.setString(2, review.getUsername());
            statement.setString(3, review.getRestaurantName());
            statement.setString(4, review.getRestaurantID());
            statement.setString(5, review.getReview());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Insert failed in ReviewStore.createReview");
            System.err.println("Message from Postgres: " + e.getMessage());
            System.exit(-1);
        }

    }

}








