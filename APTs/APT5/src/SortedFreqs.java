import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SortedFreqs {
    private HashMap<String, Integer> myMap = new HashMap<>();

    public class Data implements Comparable<Data> {
        String str;
        int count;

        public Data(String s) {
            str = s;
            count = myMap.get(s);
        }

        public String getStr() {
            return str;
        }

        public int getCount() {
            return count;
        }

        @Override
        public int compareTo(Data d) {
            return this.getStr().compareTo(d.getStr());
        }

        @Override
        public String toString() {
            return str;
        }
    }

    public int[] freqs(String[] data) {
        for (String s : data) {
            myMap.putIfAbsent(s, 0);
            myMap.put(s, myMap.get(s) + 1);
        }

        ArrayList<Data> D = new ArrayList<>();
        for (String s : myMap.keySet()) {
            D.add(new Data(s));
        }

        Collections.sort(D);

        int[] ret = new int[D.size()];

        for (int i = 0; i < D.size(); i++) {
            ret[i] = D.get(i).getCount();
        }

        return ret;
    }
}
