package practice;

import debugLaicode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderIterator {
    // fields
    Deque<TreeNode> stack;

    // constructors
    public BinaryTreePreorderIterator(TreeNode root) {
        this.stack = new LinkedList<>();
        stack.offerFirst(root);
    }

    // api
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public TreeNode next() {
        TreeNode curr = stack.pollFirst();
        // the left subtree should be traversed before right subtree,
        // since stack is LIFO, we should push right into the stack first,
        // so for the next step the top element of the stack is the left sub-tree
        if (curr.right != null) {
            stack.offerFirst(curr.right);
        }
        if (curr.left != null) {
            stack.offerFirst(curr.left);
        }
        return curr;
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

        BinaryTreePreorderIterator iterator = new BinaryTreePreorderIterator(node1);

        while (iterator.hasNext()) {
            System.out.println(iterator.next().key);
        }
    }
}
