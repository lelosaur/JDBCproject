/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author daryl
 * handles regulation within UserStore
 */
public class UserService {
    private int userID;
    private String userName;
    public void UserService(int userID, String userName){
        this.userID = userID;
        this.userName = userName;
    }
}
