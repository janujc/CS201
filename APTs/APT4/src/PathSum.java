public class PathSum {
    private int hasPathHelper(TreeNode tree, int target, int sum) {
        if (tree == null) return 0;
        if (sum + tree.info == target && tree.left == null && tree.right == null) return 1;
        if (    hasPathHelper(tree.left, target, sum + tree.info) == 1 ||
                hasPathHelper(tree.right, target, sum + tree.info) == 1) return 1;
        return 0;
    }
    public int hasPath(int target, TreeNode tree){
        return hasPathHelper(tree, target, 0);
    }
}
