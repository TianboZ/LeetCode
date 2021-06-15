package debugLaicode;

public class MaximumPathSumBinaryTreeI {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    // return max path sum starting from root
    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);


        int localmax = root.val;
        if (left > 0) localmax += left;
        if (right > 0) localmax += right;
        max = Math.max(max, localmax);

        return Math.max(left, right) > 0 ? root.val + Math.max(left, right) : root.val;
    }
}
