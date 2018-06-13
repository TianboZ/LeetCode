package debugLaicode;

public class BasicOperationInBinarySearchTreeBST {
    public TreeNode search(TreeNode root, int target) {
        // base-case
        if (root == null) {
            return null;
        }
        // recursive rule
        if (root.key == target) {
            return root;
        }
        if (root.key > target) {
            return search(root.left, target);
        }
        if (root.key < target) {
            return search(root.right, target);
        }
        return null;
    }
    // time o(height)   height = logn on average   worst case o(n)

    // insert a treenode into tree, return the new root of inserted tree
    // if the target is already there, do nothing
    // 传入一个node， 传出一个node
    public TreeNode insert(TreeNode root, int target) {
        // base-case
        if (root == null) {
            TreeNode node = new TreeNode(target);
            return node;
        }
        // recursive rule
        if (target > root.key) {
            TreeNode newRoot = insert(root.right, target);
            root.right = newRoot;
            return root;
        }
        if (target < root.key) {
            TreeNode newRoot = insert(root.left, target);
            root.left = newRoot;
            return root;
        }
        return root;
    }
    // time o(height)   height = logn on average   worst case o(n)


    // delete a treenode with, return the new root of the tree
    // 传入一个node， 传出一个node
    public TreeNode delete(TreeNode root, int key) {
        // base-case
        if (root == null) {
            return null;
        }
        // rule
        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null || root.right == null) {
                root = root.left == null ? root.right : root.left;
            } else {
                TreeNode smallest = findSmallest(root.right);
                root.key = smallest.key;
                root.right = delete(root.right, smallest.key);
            }
        }
        return root;
    }
    // find the smallest node, return the reference of it
    private TreeNode findSmallest(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        TreeNode cur = root;
        while (cur.left.left != null) {
            cur = cur.left;
        }
        return  cur.left;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);

        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;

//            5
//
//        3        6
//
//     2     4

        BasicOperationInBinarySearchTreeBST basicOperationInBinarySearchTreeBST = new BasicOperationInBinarySearchTreeBST();
        basicOperationInBinarySearchTreeBST.delete(node1, 3);

    }
}
