package debugLaicode;

import java.util.List;

public class LCA4 {
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        return lca(root, nodes);
    }

    private TreeNode lca(TreeNode root, List<TreeNode> nodes) {
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
