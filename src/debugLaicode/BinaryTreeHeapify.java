package debugLaicode;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTreeHeapify {
    private TreeNode heapify(TreeNode root) {
        // base-case
        if (root == null) return null;
        // recursive rule
        root.left = heapify(root.left);
        root.right = heapify(root.right);
        percalateDown(root);
        return root;
    }
    private void percalateDown(TreeNode root) {
        // base-case
        if (root == null) return;
        // recursive rule
        if (root.left == null && root.right == null) return;
        if (root.left != null && root.right != null) {
            TreeNode smaller = root.left.key < root.right.key ? root.left : root.right;
            if (smaller.key < root.key) {
                int tmpt = smaller.key;
                smaller.key = root.key;
                root.key = tmpt;
                percalateDown(smaller);
            }
        } else {
            TreeNode smaller = root.left;
            if (smaller.key < root.key) {
                int tmpt = smaller.key;
                smaller.key = root.key;
                root.key = tmpt;
                return;
            }
        }
        return;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(2);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        BinaryTreeHeapify binaryTreeHeapify = new BinaryTreeHeapify();
        binaryTreeHeapify.heapify(node1);

        int a = 1;
    }
}