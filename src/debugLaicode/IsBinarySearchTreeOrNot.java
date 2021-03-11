package debugLaicode;

public class IsBinarySearchTreeOrNot {
    public boolean isBST(TreeNode root) {
        // Write your solution here
        return isBST1(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    // min, max is range of tree with root. if root.val is out of range, then
    // it is not BST
    private boolean isBST1(TreeNode root, int min, int max) {
        // basecase
        if (root == null) {
            return true;
        }
        //recursive rule
        if (root.key <= min || root.key >= max) {
            return false;
        }
        return isBST1(root.left, min, root.key) && isBST1(root.right, root.key, max);
    }
}
