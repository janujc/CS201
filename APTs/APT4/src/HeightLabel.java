import java.math.*;

public class HeightLabel {
    private int height(TreeNode t) {
        if (t == null) return 0;
        if (t.left == null && t.right == null) return 1;
        return Math.max(height(t.left), height(t.right)) + 1;
    }

    public TreeNode rewire(TreeNode t) {
        if (t == null) return null;
        return new TreeNode(height(t), rewire(t.left), rewire(t.right));
    }
}
