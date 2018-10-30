import java.util.*;

public class AllPaths {
    private ArrayList<String> myList = new ArrayList<>();

    private void pathsHelper(TreeNode t, String s) {
        if (t == null) return;
        if (t.left == null && t.right == null) {
            s = s + t.info;
            myList.add(s);
            return;
        }
        s = s + t.info + "->";
        pathsHelper(t.left, s);
        pathsHelper(t.right, s);
    }

    public String[] paths(TreeNode t) {
        if (t != null) {
            pathsHelper(t, "");
        }
        Collections.sort(myList);
        return myList.toArray(new String[0]);
    }
}
