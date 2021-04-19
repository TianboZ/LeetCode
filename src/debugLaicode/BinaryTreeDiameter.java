package debugLaicode;

public class BinaryTreeDiameter {
    int max;
    public int diameter(TreeNode root) {
        // Write your solution here
        getHeight(root);
        return max;
    }
    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (root.left != null && root.right != null) {
            // leaf
            max = Math.max(max, left + 1 + right);
        }
        return Math.max(left, right) + 1;
    }
}
