package debugLaicode;

public class ConvertBSTtoGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }
    int sum = 0; // prefix sum

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.right);

        sum = sum + root.key;
        root.key = sum;

        inorder(root.left);
    }
}
