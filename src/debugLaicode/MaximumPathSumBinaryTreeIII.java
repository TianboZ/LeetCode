package debugLaicode;

public class MaximumPathSumBinaryTreeIII {
    // 一条直上直下的path中的一段sub-path(can be only one node), max path sum
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    // return max path sum from root to some node
    private int helper(TreeNode root) {
        // base case
        if (root == null) return 0;

        // recursive rule
        int left = helper(root.left);
        int right = helper(root.right);

        // update global max
        max = Math.max(max, getMax(new int[]{root.key, root.key + left, root.key + right}));

        return getMax(new int[]{root.key, root.key + left, root.key + right});
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }
}
