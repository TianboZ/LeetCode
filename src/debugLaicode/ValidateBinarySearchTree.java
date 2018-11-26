package debugLaicode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.key >= maxVal || root.key <= minVal) return false;
        return isValidBST(root.left, minVal, root.key) && isValidBST(root.right, root.key, maxVal);
    }
}
