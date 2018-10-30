import java.util.*;

public class SortedLeaves {

    private void valuesHelper(TreeNode tree, List<Character> list) {
        if (tree == null) return;
        if (tree.left == null && tree.right == null) {
            list.add((char)tree.info);
            return;
        }
        if (tree.left != null) valuesHelper(tree.left, list);
        if (tree.right != null) valuesHelper(tree.right, list);
    }

    public String[] values(TreeNode tree) {
        List<Character> list = new ArrayList<>();
        valuesHelper(tree, list);
        String[] s = new String[list.size()];
        Collections.sort(list);
        int counter = 0;
        for (Character c : list) {
            s[counter] = Character.toString(c);
            counter++;
        }
        return s;
    }
}
