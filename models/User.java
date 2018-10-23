/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import stores.UserStore;

import java.sql.*;

/**
 *
 * @author daryl
 */
public class User {
    //create User object
    private String username;
    private String userID;
    private Connection connection;

    public User(String username, String userID){
        this.username = username;
        this.userID = userID;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    public void setUserID(String userID){
        this.userID = userID;
    }
    public String getUserID(){
        return userID;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public Connection getConnection(){
        return connection;
    }


    public void createUser(User user) { //should be in UserStore
        UserStore userStore = new UserStore();
        userStore.setConnection(this.connection);
        userStore.createUser(user);

    }


}
