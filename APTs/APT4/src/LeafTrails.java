import java.util.Map;
import java.util.TreeMap;

public class LeafTrails {
    private TreeMap<Integer, String> myMap = new TreeMap<>();

    private void trailsHelper(TreeNode tree, String s) {
        if (tree == null) return;
        if (tree.left == null && tree.right == null) {
            myMap.put(tree.info, s);
            return;
        }
        if (tree.left != null) trailsHelper(tree.left, s + 0);
        if (tree.right != null) trailsHelper(tree.right, s + 1);
    }

    public String[] trails(TreeNode tree) {
        if (tree != null) {
            trailsHelper(tree, "");
        }
        String[] str = new String[myMap.size()];
        int counter = 0;
        for (int i : myMap.keySet()) {
            str[counter] = myMap.get(i);
            counter++;
        }
        return str;
    }
}
