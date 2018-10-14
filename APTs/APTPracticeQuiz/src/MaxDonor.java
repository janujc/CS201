import java.util.*;

public class MaxDonor {
    private HashMap<String, Integer> uniqueOrgs(String[] orgs, int[] amount){
        HashMap<String, Integer> map = new HashMap<>();
        int counter = 0;
        for (String s : orgs){
            if (! map.containsKey(s)){
                map.put(s, 0);
            }
            map.put(s, map.get(s) + amount[counter]);
            counter++;
        }
        return map;
    }

    public String generous(String[] orgs, int[] amount) {
        HashMap<String, Integer> map = uniqueOrgs(orgs, amount);
        int max = Collections.max(map.values());
        for(String s : map.keySet()) {
            if (map.get(s) == max) return s + ":$" + max;
        }
        return "";
    }
}
