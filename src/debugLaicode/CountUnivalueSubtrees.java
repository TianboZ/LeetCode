package debugLaicode;

public class CountUnivalueSubtrees {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        // Write your solution here
        allSame(root);
        return count;
    }
    private boolean allSame(TreeNode root) {
        // base-case
        if (root == null) {
            return true;
        }
        // rule
        boolean left = allSame(root.left);
        boolean right = allSame(root.right);
        if (root.left != null && root.right != null) {
            if (left && right && root.key == root.left.key && root.key == root.right.key) {
                count++;
                return true;
            }
        }
        if (root.left == null && root.right != null) {
            if (right && root.key == root.right.key) {
                count++;
                return true;
            }
        }
        if (root.right == null && root.left != null) {
            if (left && root.key == root.left.key) {
                count++;
                return true;
            }
        }
        if (root.left == null && root.right == null) {
            count++;
            return true;
        }
        return false;
    }
}
