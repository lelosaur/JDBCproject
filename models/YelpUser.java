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
public class YelpUser {
    private String username;
    private int userID;
    
    public YelpUser(String username, int userID){
        this.username = username;
        this.userID = userID;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    public void setUserID(int userID){
        this.userID = userID;
    }
    public int getUserID(){
        return userID;
    }

}
