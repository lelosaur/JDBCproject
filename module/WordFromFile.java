package module;

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

    public List<String> TextFileReader(Scanner textfile){
        List<String> readinlist = new ArrayList<String>();
        String nextinlist;
        //place all String username values into list usernametestlist
        while (textfile.hasNext()) {
            //String[] tokens = scanner.nextLine().split(";");
            //separates by line. Use .split(;) for ; as delimiter
            nextinlist = textfile.nextLine();
            readinlist.add(nextinlist);
        }
        return readinlist;
    }
}
