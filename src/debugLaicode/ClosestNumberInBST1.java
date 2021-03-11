package debugLaicode;

public class ClosestNumberInBST1 {
    public int closest(TreeNode root, int target) {
        // Write your solution here
        // sanity check
        if (root == null) return -1;

        int diff = Integer.MAX_VALUE;
        TreeNode res  = null;
        while (root != null) {
            if (root.key == target) {
                return target;
            }
            if (Math.abs(root.key - target) < diff) {
                res = root;
                diff = Math.abs(root.key - target);
            }
            if (target < root.key) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return res.key;
    }
}
