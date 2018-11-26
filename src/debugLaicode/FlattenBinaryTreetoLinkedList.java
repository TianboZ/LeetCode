package debugLaicode;

public class FlattenBinaryTreetoLinkedList {
    // solution1
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        // base-case
        if (root == null) return;

        // recursive rule
        if (prev != null) prev.right = root;
        prev = root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;

        flatten(left);
        flatten(right);
    }

    // solution2
    public void flatten1(TreeNode root) {
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