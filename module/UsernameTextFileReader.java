package module;
        import java.util.*;

public class UsernameTextFileReader { // logic for reading text files

    public List<String> UsernameTextFileReader(Scanner usernametextfile){
        List<String> usernametestlist = new ArrayList<String>();
        String unametestnext;
        //place all String username values into list usernametestlist
        while (usernametextfile.hasNext()) {
            unametestnext = usernametextfile.next();
            usernametestlist.add(unametestnext);
        }
        return usernametestlist;
    }
}
