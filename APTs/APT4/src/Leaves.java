import java.util.ArrayList;

public class Leaves {
    private ArrayList<Integer> myList = new ArrayList<>();

    private void getLeavesHelper(TreeNode t) {
        if (t == null) return;
        if (t.left == null && t.right == null) {
            myList.add(t.info);
            return;
        }
        if (t.left != null) getLeavesHelper(t.left);
        if (t.right != null) getLeavesHelper(t.right);
    }

    public int[] getLeaves(TreeNode t) {
        getLeavesHelper(t);
        int[] count = new int[myList.size()];;
        for (int i = 0; i < count.length; i++) {
            count[i] = myList.get(i);
        }
        return count;
    }
}
