package debugLaicode;

public class MaximumPathSumBinaryTreeII {
    int max = Integer.MIN_VALUE;
    //    Find the maximum possible sum from any node to any node.
    public int maxPathSum(TreeNode root) {
        findPathSum(root);
        return max;
    }
    // largestSmaller the max single path  sum（从root开始，到某个点结束） from tree
    private int findPathSum(TreeNode root) {
        // base-case
        if (root == null) {
            return 0;
        }
        // recursive rule
        int left = findPathSum(root.left);
        int right = findPathSum(root.right);

        // update max
        max = Math.max(max, left + right + root.key);
        max = Math.max(max, right + root.key);
        max = Math.max(max, left + root.key);
        max = Math.max(max, root.key);

        int tmp = Integer.MIN_VALUE;
        tmp = Math.max(tmp, left + root.key);
        tmp = Math.max(tmp, right + root.key);
        tmp = Math.max(tmp, root.key);

        return tmp;
    }
}
