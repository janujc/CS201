public class SumTwoTrees {
    public TreeNode add(TreeNode a, TreeNode b) {
        if (a == null && b != null) return b;
        if (a != null && b == null) return a;
        if (a == null && b == null) return null;
        a.info += b.info;
        a.left = add(a.left, b.left);
        a.right = add(a.right, b.right);
        return a;
    }


}
