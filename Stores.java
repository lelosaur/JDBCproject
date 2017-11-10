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
public class Stores {
    private String store;
    private int storeID;

    public Stores(String store, int storeID){
        this.store = store;
        this.storeID = storeID;

    }
    
    public void setStore(){
        this.store = store;
    }
    public String getStore(){
        return store;
        
    }
    public void setStoreID(){
    this.storeID = storeID;
}
    public int getStoreID(){
        return storeID;
    }

    
}
