package debugLaicode;

public class LongestUnivaluePath {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        // edges = nodes - 1
        return root == null ? 0 : max - 1;
    }
    // return longest uni value path starts from the root
    private int dfs(TreeNode root) {
        // base-case
        if (root == null) {
            return 0;
        }
        // recursive rule
        int left = dfs(root.left);
        int right = dfs(root.right);

        int local = 1; // can be: left + root or right + root
        int path = 1; // can be: left + root + right
        if (root.left != null && root.left.val == root.val) {
            local = Math.max(local, left + 1);
            path += left;
        }
        if (root.right != null && root.right.val == root.val) {
            local = Math.max(local, right + 1);
            path += right;
        }

        // update global max
        if (path > max) max = path;

        return local;
    }
}
