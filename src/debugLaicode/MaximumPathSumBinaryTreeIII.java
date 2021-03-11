package debugLaicode;

public class MaximumPathSumBinaryTreeIII {
    // 一条直上直下的path中的一段sub-path(can be only one node), max path sum
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};

        helper(root, max);
        return max[0];
    }

    // return max path sum from root to some-node
    private int helper(TreeNode root, int[] max) {
        // basecase
        if (root == null) {
            return 0;
        }
        // recursive rule
        int left = helper(root.left, max);
        int right = helper(root.right, max);

        int maxSum = findMax(new int[] {
                root.key,
                root.key + left,
                root.key + right,
        });
        max[0] = Math.max(max[0], maxSum);
        return maxSum;
    }

    private int findMax(int[] arr) {
        int max = arr[0];
        for (int ele : arr) {
            max = Math.max(max, ele);
        }
        return max;
    }
}
