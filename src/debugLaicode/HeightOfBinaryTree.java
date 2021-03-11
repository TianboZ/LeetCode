package debugLaicode;

public class HeightOfBinaryTree {
    public int findHeight(TreeNode root) {
        // Write your solution here
        //basecase
        if (root == null) {
            return 0;
        }

        // recursive rule
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }
}
