package module;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UsernameTextFileReader  { // logic for comparing username from a text file



    public UsernameTextFileReader(){

    }
//converts a text file into a list, and iterates through it while comparing to a test username to decide validity
    public String testUsername(Scanner textFile, String testUserName){
       WordFromFile wordFromFile = new WordFromFile();
       
        List<String> textFileReader;
       textFileReader =  wordFromFile.TextFileReader(textFile);

        for(int i = 0; i < textFileReader.size(); i++){
            if(testUserName == textFileReader.get(i)){
                return null;
            }
        }
        return testUserName;


    }



    //you're not getting the point of this. WordFromFile parses the text file and UsernameTextFileReader takes a <String>
    //and compares each value to the proposed username. so UTFR.java will take in a single STRING, use WFF to read in
    //the text file

    }

