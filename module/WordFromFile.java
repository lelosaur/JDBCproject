package module;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordFromFile implements WordPopulator {

    public WordFromFile(){

    }

    @Override
    public List<String> getWord() {

        return null;
    }
    /*
    public void read(File file) throws IOException{
    Scanner scanner = new Scanner(file);

    while(scanner.hasNext()){
        String[] tokens = scanner.nextLine().split(";");
        String last = tokens[tokens.length - 1];
        System.out.println(last);
    }
}
     */
    //reads in File and parses through using lines as delimiter. Stores in and returns List readinlist
    public List<String> TextFileReader(File file) throws Exception{
        List<String> readinlist = new ArrayList<String>();
        String nextinlist;
        //place all String username values into list usernametestlist
        Scanner textfile = new Scanner(file);
        while (textfile.hasNext()) {
            //String[] tokens = scanner.nextLine().split(";");
            //separates by line. Use .split(;) for ; as delimiter
            nextinlist = textfile.nextLine();
            readinlist.add(nextinlist);
        }
        return readinlist;
    }
}
