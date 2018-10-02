package debugLaicode;

public class LCAofBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base-case
        if (root == null) return root;

        // recursive rule
        if (p.key < root.key && q.key < root.key) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.key > root.key && q.key > root.key) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}