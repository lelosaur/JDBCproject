package service;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author daryl
 * handles regulation within UserStore
 */
public class UserService {
    private String username;
    private String[] usernametest;

    public void UserService(String[] usernametest, String username) {
        this.username = username;
        this.usernametest = usernametest;
    }


    public void setUserName(String userName) {
        this.username = username;
    }

    public String getUserName() {
        return username;
    }





//    public String regulateUserName(Scanner usernametest, String username) { //compares each value in list from .txt file to the proposed username
//        List<String> usernametestlist = new ArrayList<String>();
//        String unametestnext = "";
//        //place all String username values into list usernametestlist
//        while (usernametest.hasNext()) {
//            unametestnext = usernametest.next();
//            usernametestlist.add(unametestnext);
//        }
//        //finished list usernametestlist is compared with the given String username
//        for (int i = 0; i < usernametestlist.size(); i++) {
//
//            //if checks out with every single username with caps or not, then return username/maybe store it. Else, return error
//            if (usernametestlist.get(i).equalsIgnoreCase(username)) {
//                System.out.println("Invalid username, returning NULL");
//                return null;
//            }
//
//        }
//        return username;
//    }
}


