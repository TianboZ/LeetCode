package debugLaicode;

import java.util.*;

public class BinaryTreeIterativeTraverse {
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public List<TreeNode> preOrder1(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pollFirst();
            res.add(curr);
            // the left subtree should be traversed before right subtree,
            // since stack is LIFO, we should push right into the stack first,
            // so for the next step the top element of the stack is the left sub-tree
            if (curr.right != null) {
                stack.offerFirst(curr.right);
            }
            if (curr.left != null) {
                stack.offerFirst(curr.left);
            }
        }
        return res;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public List<TreeNode> inOrder1(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        pushLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pollFirst();
            list.add(curr);
            pushLeft(curr.right, stack);
        }
        return list;
    }

    private void pushLeft(TreeNode node, Deque<TreeNode> stack) {
        while (node != null) {
            stack.offerFirst(node);
            node = node.left;
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // online solution
    public List<Integer> postOrder1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        // to record the previous node on the way of DFS so that we can determine the direction
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peekFirst();
            if (prev == null || curr == prev.left || curr == prev.right) {
                if (curr.left != null) {
                    stack.offerFirst(curr.left);
                } else if (curr.right != null) {
                    stack.offerFirst(curr.right);
                } else {
                    // if we can go either away, meaning curr is leaf node
                    stack.pollFirst();
                    res.add(curr.key);
                }
            } else if (prev == curr.right || prev == curr.left && curr.right == null) {
                // if we are going up from the r right side or going up from the left side
                // but we can not go right afterwards
                stack.pollFirst();
                res.add(curr.key);
            } else {
                // otherwise, we are going up from the left side and we can go down right side
                stack.offerFirst(curr.right);
            }
            prev = curr;
        }
        return res;
    }
}
