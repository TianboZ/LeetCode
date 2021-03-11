package debugLaicode;

public class MaximumPathSumBinaryTreeI {
    //    Given a binary tree in which each node contains an integer number.
    //    Find the maximum possible sum from one leaf node to another leaf node.
    //    If there is no such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).

    public int maxPathSum(TreeNode root) {
        // Write your solution here
        int[] max = new int[]{Integer.MIN_VALUE};

        helper(root, max);
        return max[0];
    }

    // for each recursion call, return root to leaf path sum
    private int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left, max);
        int right = helper(root.right, max);

        if (root.left != null && root.right != null) {
            max[0] = Math.max(max[0], root.key + left + right);
            return Math.max(left, right) + root.key;
        } else if (root.left == null && root.right == null) {
            return root.key;
        } else {
            return root.left == null ? root.key + right : root.key + left;
        }
    }
}
