package debugLaicode;

public class HouseRobber3 {
    public int rob(TreeNode root) {
        return helper(root);
    }

    // the max value can get from root, return int
    private int helper(TreeNode root) {
        // Write your solution here
        // base-case
        if (root == null) {
            return 0;
        }
        // recursive rule
        int max = 0;
        // case1: rob root
        int left = rob(root.left);
        int right = rob(root.right);

        // case2: not rob root
        int tmp1 = 0;
        int tmp2 = 0;
        int tmp3 = 0;
        int tmp4 = 0;

        if (root.left != null) {
            tmp1 = rob(root.left.left);
            tmp2 = rob(root.left.right);
        }
        if (root.right != null) {
            tmp3 = rob(root.right.left);
            tmp4 = rob(root.right.right);
        }

        // find the max
        max = Math.max(max, root.key + tmp1 + tmp2 + tmp3 + tmp4);
        max = Math.max(max, left + right);
        return max;
    }
}
