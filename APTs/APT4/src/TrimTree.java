public class TrimTree {
    public TreeNode trim(TreeNode t, int low, int high) {
        if (t == null) return null;
        if (t.info < low) return trim(t.right, low, high);
        if (t.info > high) return trim(t.left, low, high);
        t.left = trim(t.left, low, high);
        t.right = trim(t.right, low, high);
        return t;
    }
}
