package debugLaicode;

public class IsBinarySearchTreeOrNot {
    public boolean isBST(TreeNode root) {
        // Write your solution here
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBST(TreeNode root, int min, int max) {
        // base case
        if (root == null) {
            return true;
        }
        if (root.key < min || root.key > max) {
            return false;
        }
        // recursive rule
        boolean left = isBST(root.left, min, root.key - 1);
        boolean right = isBST(root.right, root.key + 1, max);
        return left && right;
    }
}
