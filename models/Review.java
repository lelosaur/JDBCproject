/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author daryl
 */
//utilizing as service layer? Isolating business logic?
public class Review {
    //UserID, Usersname, Storename, StoreID, review
    private int userID;
    private String username;
    private String restaurantname;
    private int restaurantID;
    private String review;
    
    
    
    
    
    public Review( int userID, String username, String restaurantname, int storeID, String review){
        this.username = username;
        this.userID = userID;
        this.review = review;
        this.restaurantname = restaurantname;
        this.restaurantID = storeID;  
    }
 
    
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    } 
    public void setReview(String review){
    this.review = review;
    }
    public String getReview(){
    return review;
    }
    public void setStorename(String restaurantname){
    this.restaurantname = restaurantname;
    }
    public String getRestaurantName(){
    return restaurantname;
    }
    public void setUserID(int userID){
    this.userID = userID;
    }
    public int getUserID(){
    return userID;
    }
    public void setRestaurantID(int restaurantID){
    this.restaurantID = restaurantID;
    }
    public int getRestaurantID(){
    return restaurantID;
    }
}
