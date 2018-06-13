package debugLaicode;

public class LargestNumberSmallerInBinarySearchTree {
    int max = Integer.MIN_VALUE;
    public int largestSmaller(TreeNode root, int target) {
        find(root, target);
        return max;
    }
    // 直上直下 void
    private void find(TreeNode root, int target) {
        // baes-cae
        if (root == null) {
            return;
        }
        // rule
        if (target > root.key) {
            max = Math.max(max, root.key);
            find(root.right, target);
        }
        if (target <= root.key) {
            find(root.left, target);
        }

    }
}
