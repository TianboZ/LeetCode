package debugLaicode;

public class SearchInBinarySearchTree {
    public TreeNode search(TreeNode root, int key) {
        // Write your solution here
        if (root == null) {
            return null;
        }

        if (root.key == key) {
            return root;
        }

        if (key < root.key) {
            return search(root.left, key);
        } else  {
            return search(root.right, key);
        }
    }
}
