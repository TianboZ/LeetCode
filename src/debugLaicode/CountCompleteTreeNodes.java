package debugLaicode;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        // Write your solution here
        // base-case
        if (root == null) {
            return 0;
        }
        // recursive rule
        int left = leftDepth(root.left);
        int right = rightDepth(root.right);
        if (left == right) {
            return ((int) Math.pow(2, left + 1) - 1);
        }
        return countNodes(root.left) + 1 + countNodes(root.right);
    }
    private int leftDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }
    private int rightDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        while (root != null) {
            root = root.right;
            depth++;
        }
        return depth;
    }
}
