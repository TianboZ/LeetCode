package debugLaicode;

public class MaxPathSumFromLeafToRoot {
    public int maxPathSumLeafToRoot(TreeNode root) {
        // Write your solution here
        int[] max = new int[]{Integer.MIN_VALUE};
        preorder(root, 0, max);
        return max[0];
    }

    // pre-order traverse tree
    private void preorder(TreeNode root, int prefixSum, int[] max) {
        // basecase
        if (root == null) return;
        if (root.left == null && root.right == null) {
            // leaf
            max[0] = Math.max(max[0], root.key + prefixSum);
        }

        // recursive rule
        preorder(root.left, prefixSum + root.key, max);
        preorder(root.right, prefixSum + root.key, max);
    }
}
