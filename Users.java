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
public class Users {
    private String Username;
    private int UserID;
    
    public Users(String Username, int UserID){
        this.Username = Username;
        this.UserID = UserID;
    }
    public void setUsername(){
        this.Username = Username;
    }
    public String getUsername(){
        return Username;
    }
    public void setUserID(){
        this.UserID = UserID;
    }
    public int getUserID(){
        return UserID;
    }

}
