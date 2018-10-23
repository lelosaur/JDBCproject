package service;
import module.UsernameTextFileReader;

import java.io.File;
import java.io.IOException;

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

    public void testUsername () throws IOException{
        File testfile = new File("C:/Users/daryl/Desktop/tests/testfile.txt");
        //Note to self:requires Throws Exception
        UsernameTextFileReader usernameTextFileReader = new UsernameTextFileReader();
        try {
            usernameTextFileReader.testUsername(testfile, "Username3");
        } catch (Exception e) {
            e.printStackTrace();
        }
        UsernameTextFileReader usernameTextFileReader2 = new UsernameTextFileReader();
        try {
            usernameTextFileReader2.testUsername(testfile, "Username4");
        } catch (Exception e) {
            e.printStackTrace();
        }

        UsernameTextFileReader usernameTextFileReaderError = new UsernameTextFileReader();
        try {
            usernameTextFileReaderError.testUsername(testfile, "ErrorUsername2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






}


