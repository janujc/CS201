public class LevelCount {
    private int countHelper(TreeNode t, int level, int counter) {
        if (t == null) return 0;
        if (counter == level) return 1;
        return countHelper(t.left, level, counter + 1) + countHelper(t.right, level, counter + 1);
    }
    public int count(TreeNode t, int level) {
        return countHelper(t, level, 0);
    }
}
