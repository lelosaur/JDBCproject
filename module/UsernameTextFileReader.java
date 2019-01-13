package module;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class UsernameTextFileReader  { // logic for comparing username from a text file



    public UsernameTextFileReader(){

    }
//converts a text file into a list, and iterates through it while comparing to a test username to decide validity
    public String testUsername(File textFile, String testUserName) throws Exception{
       WordFromFile wordFromFile = new WordFromFile();

        List<String> textFileReader;
       textFileReader =  wordFromFile.TextFileReader(textFile);


       if(textFileReader.contains(testUserName)){ // see if you can figure out an equalsIgnoreCase(username)
            System.out.println("not a valid username");
            return null;
       }
       else {
           System.out.println("Successful username!");
           return testUserName;
       }

    }
    }
    //ideally read in the file ONCE, save to a PRIVATE arraylist and use that list instead of reading directly from the
    // txt file each time.<-why you have UTFR.java AND Userservice.java(separation of concerns)

