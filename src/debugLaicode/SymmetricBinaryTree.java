package debugLaicode;

public class SymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    // check if the tree with root1 is symmetirc to the tree with root2
    private boolean isSymmetric(TreeNode root1, TreeNode root2) {
        // base-case
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.key != root2.key) {
            return false;
        }
        // recurusive rule
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }
}