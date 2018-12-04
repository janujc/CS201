import java.util.*;

public class FriendScore {

    private HashMap<Integer, Set<Integer>> myFriends = new HashMap<>();

    private void makeGraph(String[] friends) {
        Integer i = 0;
        for (String sets : friends) {
            String[] unique = sets.split("");
            myFriends.putIfAbsent(i, new HashSet<>());
            for (int j = 0; j < unique.length; j++) {
                if (unique[j].equals("Y")) {
                    myFriends.get(i).add(j);
                }
            }
            i++;
        }
    }

    private Set<Integer> twoFriends(int k) {
        HashSet<Integer> set = new HashSet<>();
        set.addAll(myFriends.get(k));
        for(int i : myFriends.get(k)) {
            set.addAll(myFriends.get(i));
        }
        set.remove(k);
        return set;
    }

    public int highestScore(String[] friends) {
        makeGraph(friends);
        int max = 0;
        for (int k = 0; k < friends.length; k++) {
            Set<Integer> set = twoFriends(k);
            max = Math.max(max, set.size());
        }
        return max;
    }
}
