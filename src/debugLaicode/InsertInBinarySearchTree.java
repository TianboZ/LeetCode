package debugLaicode;

public class InsertInBinarySearchTree {
    public TreeNode insert(TreeNode root, int key) {
        // base case
        if (root == null) {
            return new TreeNode(key);
        }

        // recursive rule
        if (root.key == key) {
            return root;
        }

        if (key < root.key) {
            root.left = insert(root.left, key);
        }

        if (key > root.key) {
            root.right = insert(root.right, key);
        }

        return root;
    }
}