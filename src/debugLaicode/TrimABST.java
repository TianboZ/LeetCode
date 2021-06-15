package debugLaicode;

public class TrimABST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // base case
        if (root == null) return null;

        // recursive rule
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        } else {
            TreeNode left = trimBST(root.left, low, root.val);
            TreeNode right = trimBST(root.right, root.val, high);

            root.left = left;
            root.right = right;
            return root;
        }
    }
}
