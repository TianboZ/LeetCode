package debugLaicode;

public class HouseRobber3 {

    // the max value can get from root, return int
    public int rob(TreeNode root) { // return the max value we can get from root’s subtree neighborhood
        // base-case
        if (root == null) return 0;

        // recursive rule
        // case1: not rob root
        int notRobRoot = rob(root.left) + rob(root.right);

        //case2: rob root
        int val = 0;
        if (root.left != null) {
            val = val + rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val = val + rob(root.right.left) + rob(root.right.right);
        }
        int robRoot = val + root.key;

        return Math.max(notRobRoot, robRoot);
    }

}
// time o(6^height)  heigh is tree's height
// space o(height)