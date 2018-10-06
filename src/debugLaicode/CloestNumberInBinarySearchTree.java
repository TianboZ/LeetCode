package debugLaicode;

public class CloestNumberInBinarySearchTree {
    // sol1: recurtion
    int num = Integer.MAX_VALUE;
    // recursive
    public int closest(TreeNode root, int target) {
        findCloset(root, target);
        return num;
    }
    // 直上直下
    // largestSmaller the cloest number in the tree
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

    // sol2: iterative
    public int closest1(TreeNode root, int target) {
        // Write your solution here
        int diff = Integer.MAX_VALUE;
        int res = 0;
        while (root != null) {
            if (root.key == target) {
                return root.key;
            } else {
                if (Math.abs(target - root.key) < diff) {
                    diff = Math.abs(target - root.key);
                    res = root.key;
                }
                if (root.key > target) {
                    root  = root.left;
                } else {
                    root = root.right;
                }
            }
        }
        return res;
    }
}
