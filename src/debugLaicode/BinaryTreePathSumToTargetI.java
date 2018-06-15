package debugLaicode;

public class BinaryTreePathSumToTargetI {
    public boolean exist(TreeNode root, int target) {
        // Write your solution here
        // base-case
        if (root == null) {
            return false;
        }
        // recursive rule
        if (root.left == null && root.right == null && root.key == target) {
            return true;
        }
        return exist(root.left, target - root.key) || exist(root.right, target - root.key);
    }
}
