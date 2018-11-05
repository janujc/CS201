public class DepthSum {

    private int valueHelper(TreeNode t, int i) {
        if (t == null) return 0;
        if (t.left == null && t.right == null) return t.info * i;
        return valueHelper(t.left, i + 1) + valueHelper(t.right, i + 1) + t.info * i;
    }

    public int value(TreeNode tree){
        return valueHelper(tree, 1);
    }
}
