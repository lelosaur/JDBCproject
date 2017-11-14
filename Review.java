/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.project;
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
    private String storename;
    private int storeID;
    private String review;
    
    
    
    
    
    public Review( int userID, String username, String storename, int storeID, String review){
        this.username = username;
        this.userID = userID;
        this.review = review;
        this.storename = storename;
        this.storeID = storeID;  
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
    public void setStorename(String storename){
    this.storename = storename;
    }
    public String getStorename(){
    return storename;
    }
    public void setUserID(int userID){
    this.userID = userID;
    }
    public int getUserID(){
    return userID;
    }
    public void setStoreID(int storeID){
    this.storeID = storeID;
    }
    public int getStoreID(){
    return storeID;
    }
}
