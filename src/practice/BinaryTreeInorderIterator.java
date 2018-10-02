package practice;

import debugLaicode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class BinaryTreeInorderIterator {
    // fields
    Deque<TreeNode> stack;

    // constructor
    public BinaryTreeInorderIterator(TreeNode root) {
        this.stack = new LinkedList<>();
        while (root != null) {
            stack.offerFirst(root);
            root = root.left;
        }
    }

    // API
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public TreeNode next() {
        TreeNode curr = stack.pollFirst();
        pushLeft(curr.right, stack);
        return curr;
    }

    private void pushLeft(TreeNode node, Deque<TreeNode> stack) {
        while (node != null) {
            stack.offerFirst(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.right = node6;

        BinaryTreeInorderIterator iterator = new BinaryTreeInorderIterator(node1);
        while (iterator.hasNext()) {
            System.out.println(iterator.next().key);
        }
    }
}
