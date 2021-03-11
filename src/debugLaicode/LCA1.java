package debugLaicode;

/*
* assumption:
* node a and b are guaranteed exist in the tree
* */
public class LCA1 {
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
