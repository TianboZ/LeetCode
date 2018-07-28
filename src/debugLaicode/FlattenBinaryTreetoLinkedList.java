package debugLaicode;

public class FlattenBinaryTreetoLinkedList {
    public TreeNode flatten(TreeNode root) {
        // Write your solution here
        return helper(root);
    }
    // give root, flat it into linedlist, return root
    private TreeNode helper(TreeNode root) {
        // base-case
        if (root == null) {
            return null;
        }
        // recursive rule
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        TreeNode tail = findTail(left);
        root.left = null;
        // case1
        if (tail != null) {
            root.right = left;
            tail.right = right;
            return root;
        }
        // case2
        root.right = right;
        return root;
    }
    private TreeNode findTail(TreeNode root) {
        if (root == null || root.right == null) {
            return root;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}
