/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import stores.ReviewStore;

import java.sql.Connection;

/**
 * @author daryl
 */
//utilizing as service layer? Isolating business logic?
public class Review {
    //UserID, Usersname, Storename, StoreID, review
    private String userID;
    private String username;
    private String restaurantName;
    private String restaurantID;
    private String review;
    private Connection connection;


    public Review(String userID, String username, String restaurantName, String storeID, String review) {
        this.username = username;
        this.userID = userID;
        this.review = review;
        this.restaurantName = restaurantName;
        this.restaurantID = storeID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setStorename(String restaurantname) {
        this.restaurantName = restaurantname;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(String restaurantID) {
        this.restaurantID = restaurantID;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;

    }

    public void storeReview(/*Review review*/) { //should be in ReviewStore
        ReviewStore reviewStore = new ReviewStore(this.getConnection());
        Review tempReview = new Review(getUserID(), getUsername(), getRestaurantName(), getRestaurantID(), getReview());
        reviewStore.createReview(tempReview);
    }
}
