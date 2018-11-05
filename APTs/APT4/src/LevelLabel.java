public class LevelLabel {
    private int level(TreeNode t, int level) {
        if (t == null) return 0;
        if (t.left != null && t.right != null) return level;
        return Math.max(level(t.left, level + 1), level(t.right, level + 1)) + 1;
    }

    public TreeNode recharge(TreeNode t) {
        if (t == null) return null;
        return new TreeNode(level(t, 1), recharge(t.left), recharge(t.right));
    }
}
