package debugLaicode;

public class BinaryTreeLongestConsecutiveSequence {
    int max;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return max;
    }
    // return longest consecutive sequence from root
    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        int local = 1;
        if (root.left != null && root.left.val == root.val + 1) {
            local += left;
        }

        int local2 =1;
        if (root.right != null && root.right.val == root.val + 1) {
            local2 += right;
        }

        // update global max
        max = Math.max(max, Math.max(local, local2));

        return Math.max(local, local2);
    }

}
