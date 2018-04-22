package service;
import java.io.File;

/**
 *
 * @author daryl
 * handles regulation within UserStore
 */
public class UserService {
    private String username;
    private File usernametestfile;


    public void UserService(File usernameTestFile, String username) {
        this.username = username;
        this.usernametestfile = usernameTestFile;
    }


    public void setUserName(String userName) {

        this.username = username;
    }

    public String getUserName() {
        return username;
    }
    public void setUserNameTestFile(File usernametestfile){
        this.usernametestfile = usernametestfile;
    }
    public File getUsernametestfile(){
        return usernametestfile;
    }






}


