package debugLaicode;

import java.util.Set;

public class LCA4 {
    // lca of K nodes
    public TreeNode lca(TreeNode root, Set<TreeNode> nodes) {
        // base-case
        if (root == null) {
            return null;
        }
        if (nodes.contains(root)) {
            return root;
        }
        // recursive rule
        TreeNode left = lca(root.left, nodes);
        TreeNode right = lca(root.right, nodes);
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
