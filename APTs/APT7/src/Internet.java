import java.util.*;

public class Internet {
    private HashMap<String, Set<String>> myMap = new HashMap<>();
    private int artPoint = 0;

    private void makeMap(String[] routers) {
        Integer counter = 0;
        for (String sets : routers) {
            String count = counter.toString();
            String[] splitSets = sets.split(" ");
            List<String> list = Arrays.asList(splitSets);
            myMap.put(count, new HashSet<>());
            myMap.get(count).addAll(list);
            counter++;
        }
    }

    private Set<String> reachFromSkip(String start, String vertex){
        Set<String> visited = new HashSet<>();
        Queue<String> qu = new LinkedList<>();
        visited.add(start);
        qu.add(start);
        while (qu.size() > 0){
            String router = qu.remove();
            for(String connectedRouters : myMap.get(router)){
                if (connectedRouters.equals(vertex)) continue;
                if (! visited.contains(connectedRouters)) {
                    visited.add(connectedRouters);
                    qu.add(connectedRouters);
                }
            }
        }
        return visited;
    }

    public int articulationPoints(String[] routers) {
        makeMap(routers);
        for (int k = 0; k < routers.length; k++) {
            String vertex = "" + k;
            String start = "0";
            if (k == 0) start = "1";
            Set<String> set = reachFromSkip(start, vertex);
            if (set.size() != routers.length - 1) artPoint++;
        }
        return artPoint;
    }
}
