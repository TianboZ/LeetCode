package debugLaicode;

public class LCA1 {
    // try to find lca of a and b, if did not find both of them, return null
    // if find either of them, then return it
    public TreeNode lca(TreeNode root, TreeNode a, TreeNode b) {
        // baase-case
        if (root == null) {
            return null;
        }
        if (root == a || root == b) {
            return root;
        }
        // recursive rule
        TreeNode left = lca(root.left, a, b);
        TreeNode right = lca(root.right, a, b);

        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
