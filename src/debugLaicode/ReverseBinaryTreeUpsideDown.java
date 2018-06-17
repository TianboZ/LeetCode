package debugLaicode;

public class ReverseBinaryTreeUpsideDown {
    public TreeNode reverse(TreeNode root) {
        // base-case
        if (root == null || root.left == null) {
            return root;
        }
        // recursive rule
        TreeNode newRoot = reverse(root.left);
        root.left.left = root;
        root.left.right = root.right;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
