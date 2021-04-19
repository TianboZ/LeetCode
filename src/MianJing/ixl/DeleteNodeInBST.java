package MianJing.ixl;

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        // basecase
        if (root == null) {
            return null;
        }
        // recursive rule
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                // leaf node
                return null;
            } else if (root.left == null) {
                // node to be deleted has no left subtree
                return root.right;
            } else if (root.right == null) {
                // node to be deleted has no right subtree
                return root.left;
            } else {
                //node to be deleted has left and right subtree
                TreeNode node = findSmallest(root.right);
                root.val = node.val;

                root.right = deleteNode(root.right, node.val);
                return root;

                // TreeNode largest = findLargest(root.left);
                // root.val = largest.val;
                // root.left = deleteNode(root.left, largest.val);
                // return root;
            }
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }


    // option 1
    // find largest in left subtree
    private TreeNode findLargest(TreeNode root) {
        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }


    // option2
    // find smallest in right subtree
    private TreeNode findSmallest(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}
