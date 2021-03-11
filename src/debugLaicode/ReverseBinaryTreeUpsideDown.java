package debugLaicode;

public class ReverseBinaryTreeUpsideDown {
    // return new root of reversed tree
    public TreeNode reverse(TreeNode root) {
        // base case
        if (root == null || root.left == null) return null;

        // recursive rule
        TreeNode left = root.left;
        TreeNode right  = root.right;

        // disconnect root.left root.right
        root.left = null;
        root.right = null;

        // reconnect
        TreeNode newRoot = reverse(left);
        left.left = root;
        left.right = right;

        return newRoot;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
    }
}
