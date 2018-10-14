import java.util.*;

public class StringCuts {
    private boolean noDuplicates(String a, String[] list){
        HashSet<String> s1 = new HashSet<>(Arrays.asList(list));
        if (s1.contains(a)) return false;
        return true;
    }
    private int numStrings(String[] list, int minLength) {
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].length() >= minLength) count++;
        }
        return count;
    }
    /*public String[] filter(String[] list, int minLength) {
        int count = numStrings(list, minLength);
        String[] s = new String[count];
        int counter = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].length() >= minLength) {
                if (noDuplicates(list[i], s)) {
                    s[counter] = list[i];
                    counter++;
                }
            }
        }
        String[] s2 = new String[counter];
        int a = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].length() >= minLength) {
                if (noDuplicates(list[i], s2)) {
                    s2[a] = list[i];
                    a++;
                }
            }
        }
        return s2;
    }*/

    public String[] filter(String[] list, int minLength)
    {
        List<String> returnAList = new ArrayList<>();
        for (String s : list)
        {
            if (s.length() >= minLength && !returnAList.contains(s)) {
                returnAList.add(s);
            }
        }
        return returnAList.toArray(new String[0]);
    }
}
