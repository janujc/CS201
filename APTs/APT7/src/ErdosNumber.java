import java.util.*;

public class ErdosNumber {
    private TreeMap<String, Set<String>> myGraph = new TreeMap<>();
    private TreeMap<String, Integer> myDistance = new TreeMap<>();

    private void makeGraph(String[] pubs) {
        for (String s : pubs) {
            String[] t = s.split(" ");
            List<String> list = Arrays.asList(t);
            for (String auth : t) {
                myGraph.putIfAbsent(auth, new TreeSet<>());
                myGraph.get(auth).addAll(list);
            }
        }
    }

    private Set<String> bfsErdos() {
        Set<String> visited = new TreeSet<>();
        Queue<String> qu = new LinkedList<>();
        visited.add("ERDOS");
        qu.add("ERDOS");
        myDistance.put("ERDOS", 0);
        while (qu.size() > 0){
            String auth = qu.remove();
            for(String colab : myGraph.get(auth)){
                if (! visited.contains(colab)) {
                    visited.add(colab);
                    qu.add(colab);
                    myDistance.put(colab, myDistance.get(auth) + 1);
                }
            }
        }
        return visited;
    }

    public String[] calculateNumbers(String[] pubs) {
        makeGraph(pubs);
        ArrayList<String> list = new ArrayList<>();
        bfsErdos();
        for (String s : myGraph.keySet()) {
            if (myDistance.containsKey(s)) {
                s = s + " " + myDistance.get(s);
            }
            list.add(s);
        }
        return list.toArray(new String[0]);
    }
}
