package debugLaicode;

public class MaximumPathSumBinaryTreeI {
    //    Given a binary tree in which each node contains an integer number.
    //    Find the maximum possible sum from one leaf node to another leaf node.
    //    If there is no such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // Write your solution here
        findRootToLeafPathSum(root);
        return max;
    }

    // largestSmaller the max path sum from root to leaf, return int
    private int findRootToLeafPathSum(TreeNode root) {
        // base-caes
        if (root == null) {
            return 0;
        }
        // recursive rule
        int left = findRootToLeafPathSum(root.left);
        int right = findRootToLeafPathSum(root.right);

        // update only when needed
        if (root.left != null && root.right != null) {
            max = Math.max(max, left + root.key + right);
        }

        if (root.left == null) {
            return root.key + right;
        } else if (root.right == null) {
            return root.key + left;
        }
        return Math.max(left, right) + root.key;
    }
}
