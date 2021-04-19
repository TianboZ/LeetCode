package debugLaicode;

public class BinaryTreePathSumToTargetI {
    public boolean exist(TreeNode root, int target) {
        // Write your solution here
        return helper(root, target, 0);
    }
    private boolean helper(TreeNode root, int target, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            if (sum + root.key == target) return true;

            return false;
        }

        if (helper(root.left, target, sum + root.key)) return true;
        if (helper(root.right, target, sum + root.key)) return true;
        return false;
    }
}
