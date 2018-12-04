import java.util.HashMap;
import java.util.Set;

public class HuffmanDecoding {
    private HashMap<String, String> myDictionary = new HashMap<>();

    private void makeDic(String[] dictionary) {
        Character c = 'A';
        for (int i = 0; i < dictionary.length; i++) {
            myDictionary.putIfAbsent(dictionary[i], c.toString());
            c++;
        }
    }

    private String letter(String code) {
        for (int i = 0; i < code.length(); i++) {
            if (myDictionary.keySet().contains(code.substring(0, i + 1))) {
                return myDictionary.get(code.substring(0, i + 1));
            }
        }
        return "";
    }

    public String decode(String archive, String[] dictionary) {
        makeDic(dictionary);
        String str = "";
        int current = 0;
        for (int i = 0; i < archive.length() + 1; i++) {
            if (myDictionary.keySet().contains(archive.substring(current, i))) {
                str = str + letter(archive.substring(current, i));
                current = i;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String s = "101101";
        String[] str = {"00", "10", "01", "11"};
        HuffmanDecoding test = new HuffmanDecoding();
        test.makeDic(str);
        for(String t : test.myDictionary.keySet()) {
            System.out.println(test.myDictionary.get(t));
        }
    }
}