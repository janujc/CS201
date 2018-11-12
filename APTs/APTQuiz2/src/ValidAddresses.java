import java.util.ArrayList;
import java.util.Collections;

public class ValidAddresses {
    private ArrayList<String> myList = new ArrayList<>();

    private boolean isPossible(String string) {
        int number = Integer.parseInt(string);
        if (string.charAt(0) == '0' && string.length() > 1) return false;
        if (number >= 0 && number <= 255) return true;
        return false;
    }

    private void createList(String remaining, String pre, int left) {
        for (int i = 0; i < Math.min(3, remaining.length()); i++) {
            if (isPossible(remaining.substring(0, i+1)) && remaining.length() <= left*3) {
                if (left == 1 && remaining.substring(0, i+1).length() == remaining.length()) {
                    myList.add(pre + "." + remaining.substring(0, i+1));
                }
                else {
                    if (left == 4) createList(remaining.substring(i+1, remaining.length()), remaining.substring(0, i+1), left-1);
                    else createList(remaining.substring(i+1, remaining.length()), pre + "." + remaining.substring(0, i+1), left-1);
                }
            }
        }
    }

    public String[] valid(String possible) {
        createList(possible, "", 4);
        Collections.sort(myList);
        return myList.toArray(new String[0]);
    }
}
