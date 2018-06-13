package debugLaicode;

public class CloestNumberInBinarySearchTree {
    int num = Integer.MAX_VALUE;
    // recursive
    public int closest(TreeNode root, int target) {
        findCloset(root, target);
        return num;
    }
    // 直上直下
    // find the cloest number in the tree
    private void findCloset(TreeNode root, int target) {
        // base-case
        if (root == null) {
            return;
        }
        if (root.key == target) {
            num = target;
            return;
        }
        // rule
        if (Math.abs(target - root.key) < num) {
            num = root.key;
        }
        if (target > root.key) {
            findCloset(root.right, target);
        }
        if (target < root.key) {
            findCloset(root.left, target);
        }
    }
}
