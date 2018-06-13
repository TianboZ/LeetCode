package debugLaicode;

public class LCA1 {
    // find the lca of a and b, return the lca node. if did not find the node a or b, return null
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

        if (left == null && right == null) {
            return null;
        } else if (left != null && right != null) {
            return root;
        } else if (left == null || right == null) {
            return left == null ? right : left;
        }
        return null;
    }
}
