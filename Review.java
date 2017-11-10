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
    private int UserID;
    private String Username;
    private String Storename;
    private int StoreID;
    private String review;
    
    
    
    
    
    public Review( int UserID, String Username, String Storename, int StoreID, String review){
        this.Username = Username;
        this.UserID = UserID;
        this.review = review;
        this.Storename = Storename;
        this.StoreID = StoreID;  
    }
 
    
    public void setUsername(){
        this.Username = Username;
    }
    public String getUsername(){
        return Username;
    } 
    public void setReview(){
    this.review = review;
    }
    public String getReview(){
    return review;
    }
    public void setStorename(){
    this.Storename = Storename;
    }
    public String getStorename(){
    return Storename;
    }
    public void setUserID(){
    this.UserID = UserID;
    }
    public int getUserID(){
    return UserID;
    }
    public void setStoreID(){
    this.StoreID = StoreID;
    }
    public int getStoreID(){
    return StoreID;
    }
}
