package debugLaicode;

import java.util.*;

public class BinaryTreeIterativeTraverse {
    public List<TreeNode> preOrder1(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pollFirst();
            list.add(curr);
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
        return list;
    }

    public List<TreeNode> inOrder(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            // always try go to the left side to see if there is any node
            // should be traversed before the cur node, cur node is stored
            // on stack since it has not been traversed yet.
            if (curr != null) {
                stack.offerFirst(curr);
                curr = curr.left;
            } else {
                // if can not go left, meaning all the nodes on the left side
                // of the top node on stack have been traversed, the next traversal
                // node should be the top node on stack
                curr = stack.pollFirst();
                list.add(curr);
                // the next subtree we want to traverse is cur.right
                curr = curr.right;
            }
        }
        return list;
    }

    // bad method
    public List<TreeNode> postOrder(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            // pre-order: root, left, right
            // post-order: left, right, root.
            // root, right, left => reverse() => left, right, root
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }

            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            list.add(cur);
        }
        // root, right, left => reverse() => left, right, root
        Collections.reverse(list);
        return list;
    }
}
