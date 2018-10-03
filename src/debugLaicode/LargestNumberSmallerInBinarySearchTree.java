package debugLaicode;

public class LargestNumberSmallerInBinarySearchTree {
    // sol1:
    int max = Integer.MIN_VALUE;
    public int largestSmaller(TreeNode root, int target) {
        traverse(root, target);
        return max;
    }
    // 直上直下 void
    private void traverse(TreeNode root, int target) {
        // baes-cae
        if (root == null) {
            return;
        }
        // rule
        if (target > root.key) {
            max = root.key;
            traverse(root.right, target);
        } else {
            traverse(root.left, target);
        }

    }

    // sol2, iterative
    public int largestSmaller1(TreeNode root, int target) {
        int res = Integer.MIN_VALUE;
        while (root != null) {
            if (root.key < target) {
                res = root.key;
                root = root.right;

            } else {
                root = root.left;
            }
        }
        return res;
    }
}
