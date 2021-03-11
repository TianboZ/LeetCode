package debugLaicode;

public class DeleteInBinarySearchTree {
    public TreeNode deleteTree(TreeNode root, int key) {
        // Write your solution here
        // basecase
        if (root == null) {
            return null;
        }
        // recursive rule
        if (root.key == key) {
            if (root.left == null && root.right == null) {
                // leaf node
                return null;
            } else if (root.left == null) {
                // node to be deleted has no left subtree
                return root.right;
            } else if (root.right == null) {
                // node to be deletemad has no right subtree
                return root.left;
            } else {
                // node to be deleted has left and right subtree
                TreeNode node = successor(root);
                root.key = node.key;

                root.right = deleteTree(root.right, node.key);
                return root;
            }
        }
        if (key < root.key) {
            root.left = deleteTree(root.left, key);
        }
        if (key > root.key) {
            root.right = deleteTree(root.right, key);
        }
        return root;
    }

    // find successor of root node
    private TreeNode successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}


// time o(h)
// space o(h)
