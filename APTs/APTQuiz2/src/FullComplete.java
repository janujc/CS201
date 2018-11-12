public class FullComplete {
    public TreeNode create(int n) {
        if (n == 0) return null;
        n = n - 1;
        TreeNode t = new TreeNode(2, create(n), create(n));
        return t;
    }
}
