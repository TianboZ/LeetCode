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
class Solution1 {
    // o(n) method:
    public void flatten(TreeNode root) {
        dfs(root);
        //return root;
    }
    // flat the subtree starts from root, return the tail
    private TreeNode dfs(TreeNode root) {
        // base-case
        if (root == null) {
            return null;
        }
        // recursive rule
        TreeNode tail1 = dfs(root.left);
        TreeNode tail2 = dfs(root.right);

        TreeNode right = root.right;
        TreeNode left = root.left;

        if (tail1 != null && tail2 != null) {
            root.left = null;
            root.right = left;
            tail1.right = right;
            return tail2;
        }
        if (tail1 != null && tail2 == null) {
            root.left = null;
            root.right = left;
            return tail1;
        }
        if (tail1 == null && tail2 != null) {
            return tail2;
        }
        return root;
    }
}
