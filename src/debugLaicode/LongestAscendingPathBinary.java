package debugLaicode;

public class LongestAscendingPathBinary {
    int max = 0;
    public int longest(TreeNode root) {
        // Write your solution here
        helper(root);
        return max;
    }

    // return longest path from root to some node
    private int helper(TreeNode root) {
        // basecase
        if (root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        // update global
        int local = Integer.MIN_VALUE;
        if (root.left != null && root.key < root.left.key) {
            local = Math.max(local, left + 1);
        }
        if (root.right != null && root.key < root.right.key) {
            local = Math.max(local, right + 1);
        }
        local = Integer.MIN_VALUE == local ? 1 : local;
        max = Math.max(max, local);

        return local;
    }
}
