package debugLaicode;

import java.util.HashSet;
import java.util.Set;

public class SmallestSubtreeWithAllTheDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int height = getHeight(root);
        Set<TreeNode> nodes = new HashSet<>();

        preorder(root, nodes, height, 1);
        return lca(root, nodes);
    }
    // get Deepest Leaf Nodes
    private void preorder(TreeNode root, Set<TreeNode> nodes, int height, int curr) {
        if (root == null) return;

        if (curr == height) {
            nodes.add(root);
        }
        preorder(root.left, nodes, height, curr + 1);
        preorder(root.right, nodes, height, curr + 1);
    }
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    private TreeNode lca(TreeNode root, Set<TreeNode> nodes) {
        // base-case
        if (root == null) return root;
        if (nodes.contains(root)) return root;

        // rule
        TreeNode left = lca(root.left, nodes);
        TreeNode right = lca(root.right, nodes);

        if (left != null && right != null) return root;

        if (left != null) return left;
        if (right != null) return right;

        return null;
    }
}
