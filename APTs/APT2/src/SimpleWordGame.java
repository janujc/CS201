import java.util.Arrays;
import java.util.HashSet;

public class SimpleWordGame {
    private int answer(HashSet<String> set){
        int ret = 0;
        for (String s: set) {
            ret += Math.pow(s.length(), 2);
        }
        return ret;
    }

    public int points(String[] player,
                      String[] dictionary) {

        HashSet<String> s1 = new HashSet<>(Arrays.asList(player));
        HashSet<String> s2 = new HashSet<>(Arrays.asList(dictionary));
        s2.retainAll(s1);

        return answer(s2);
    }
}
