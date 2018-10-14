import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Starter {
    private String[] removeDuplicates(String[] words) {
        Set<String> s1 = new HashSet<>(Arrays.asList(words));
        return s1.toArray(new String[0]);
    }

    public int begins(String[] words, String first) {
        int counter = 0;
        String[] newWords = removeDuplicates(words);
        char[] newFirst = first.toCharArray();
        for (int i = 0; i < newWords.length; i++) {
            char[] newString = newWords[i].toCharArray();
            if (newFirst[0] == newString[0]) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        String[] testArray = {"aaa", "aaa", "bbb", "aba"};
        for (String s : (new Starter()).removeDuplicates(testArray)) System.out.println(s);
    }
}
