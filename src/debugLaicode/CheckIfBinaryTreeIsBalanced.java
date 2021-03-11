package debugLaicode;

public class CheckIfBinaryTreeIsBalanced {
    public boolean isBalanced(TreeNode root) {
        // Write your solution here
        return getHeight(root) == -1 ? false : true;
    }

    // get height of tree with root. if tree is not balanced, return -1
    private int getHeight1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight1(root.left);
        int right = getHeight1(root.right);

        if (left == -1 || right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    // get the height of tree, return -1 if the tree is not balanced, otherwise return height
    private int getHeight(TreeNode root) {
        // base-case
        if (root == null) {
            return 0;
        }

        // recursive rule
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left == - 1 || right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right)  + 1;
    }



    public static void main(String[] args) {
        System.out.println('1');
    }
}
