import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class SetAside {
    private String[] removeDuplicates(String[] list){
        String[] noDuplicates = new String[list.length];
        for (int i = 0; i < list.length; i++) {
            noDuplicates[i] = "";
            HashSet<String> h = new HashSet<>();
            for (String s : list[i].split(" ")) {
                h.add(s);
            }
            for (String s : h){
                noDuplicates[i] = noDuplicates[i] + s + " ";
            }
            noDuplicates[i] = noDuplicates[i].substring(0, noDuplicates[i].length() - 1);
        }
        return noDuplicates;
    }

    private String similarWords(String[] list, int length){
        String unique = "";
        int counter = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            for (String s : list[i].split(" ")) {
                if (!map.containsKey(s)) {
                    map.put(s, 0);
                }
                map.put(s, map.get(s) + 1);
                counter++;
            }
        }
        int max = Collections.max(map.values());
        if (max != length) return "";
        else {
            for (String s : map.keySet()) {
                if (map.get(s) == max) {
                    unique = unique.concat(s + " ");
                }
            }
        }
        return unique.substring(0, unique.length() - 1);
    }

    public String common(String[] list) {
        int i = list.length;
        String[] s = removeDuplicates(list);
        String a = similarWords(s, i);
        if (a.equals("")) return "";
        String[] b = a.split(" ");
        Arrays.sort(b);
        String c = "";
        for (String s2 : b){
            c = c + s2 + " ";
        }
        return c.substring(0, c.length()-1);
    }

    public static void main(String[] args) {
        String[] s = {"ant cat dog", "dog cat ant", "ant dog cat", "cat dog ant", "cat ant dog", "dog ant cat"};
        int i = s.length;
        SetAside test = new SetAside();
        String[] a = test.removeDuplicates(s);
        String b = test.similarWords(s, i);
//        for (String str : a) {
//            System.out.println(str);
//        }
        System.out.println(b);
    }
}

