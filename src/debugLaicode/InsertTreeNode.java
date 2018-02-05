package debugLaicode;

public class InsertTreeNode {
    public TreeNode insert(TreeNode root, int key) {
        // Write your solution here.
        return helper(root,key);
    }
    public TreeNode helper(TreeNode root, int target) {
        // base-case
        if (root == null) {
            return null;
        }

        if (root.key == target) {
            return root;
        }

        // recursive rule
        if (root.key < target) {
            if (root.right == null) {
                TreeNode node = new TreeNode(target);
                System.out.println(node.key);
                root.right = node;
            } else {
                root.right = helper(root.right, target);
            }
        } else if (root.key > target) {
            if (root.left == null) {
                TreeNode node = new TreeNode(target);
                System.out.println(node.key);
                root.left = node;
            } else {
                root.left = helper(root.left, target);
            }
        }
        return root;
    }

    TreeNode result;

    public void findCloset(TreeNode root, int target) {
        // base-case
        if (root == null) {
            return;
        }

        if (root.key == target) {
            result = root;
            return;
        }

        // recursive rule
        //if (target < root.key) {
            findCloset(root.left, target);
        //}
        //else if (target > root.key) {
            findCloset(root.right, target);
        //}
    }
}