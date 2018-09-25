package debugLaicode;

public class MaximumPathSumBinaryTreeIII {
    int max = Integer.MIN_VALUE;
    // 一条直上直下的path中的一段sub-path(can be only one node), max path sum
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return max;
    }

    // the max single path（从root到leaf） sum from root to leaf
    private int findMax(TreeNode root) {
        // base-case
        if (root == null) {
            return 0;
        }
        // recursive rule
        int left = findMax(root.left);
        int right = findMax(root.right);

        max = Math.max(max, left + root.key);
        max = Math.max(max, right + root.key);
        max = Math.max(max, root.key);

        int tmp = Integer.MIN_VALUE;
        tmp = Math.max(tmp, root.key);
        tmp = Math.max(tmp, root.key + left);
        tmp = Math.max(tmp, root.key + right);

        return tmp;
    }
}
