import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MedalTable {

    private HashMap<String, Medal> myMap = new HashMap<>();

    public class Medal implements Comparable<Medal> {
        String myCountry;
        int myGold;
        int mySilver;
        int myBronze;

        public Medal(String country) {
            myCountry = country;
            myGold = 0;
            mySilver = 0;
            myBronze = 0;
        }

        public String toString() {
            return myCountry + " " + myGold + " " + mySilver + " " + myBronze;
        }

        public void addMyMedal(int i) {
            if (i == 0) myGold++;
            if (i == 1) mySilver++;
            if (i == 2) myBronze++;
        }

        @Override
        public int compareTo(Medal o) {
            if (this.myGold != o.myGold) return o.myGold - myGold;
            if (this.mySilver != o.mySilver) return o.mySilver - mySilver;
            if (this.myBronze != o.myBronze) return o.myBronze - myBronze;
            if (! this.myCountry.equals(o.myCountry)) return myCountry.compareTo(o.myCountry);
            return 0;
        }
    }

    public String[] generate(String[] results) {
        for (String s : results) {
            String[] str = s.split(" ");
            for (int i = 0; i < str.length; i++) {
                myMap.putIfAbsent(str[i], new Medal(str[i]));
                myMap.get(str[i]).addMyMedal(i);
            }
        }

        ArrayList<Medal> M = new ArrayList<>();
        for (String s : myMap.keySet()) {
            M.add(myMap.get(s));
        }

        Collections.sort(M);

        String[] ret = new String[M.size()];

        for (int i = 0; i < M.size(); i++) {
            ret[i] = M.get(i).toString();
        }

        return ret;
    }
}
