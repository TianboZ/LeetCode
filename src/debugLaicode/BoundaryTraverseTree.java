package debugLaicode;

//Java program to print boundary traversal of binary tree

/* A binary tree node has data, pointer to left child
   and a pointer to right child */


import java.util.*;

// 2021
public class BoundaryTraverseTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null) return res;

        if (!isLeaf(root)) {
            res.add(root.val);
        }


        // add left boundary
        TreeNode node = root.left;
        while (node != null) {
            if (!isLeaf(node)) {
                res.add(node.val);
            }
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        // add leaves
        helper(res, root);

        // add right boundary
        Deque<Integer> stack = new LinkedList<>();
        node = root.right;
        while (node != null) {
            if (!isLeaf(node)) {
                stack.offerFirst(node.val);
            }

            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        // concatenate all
        while (!stack.isEmpty()) {
            res.add(stack.pollFirst());
        }
        return res;
    }
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private void helper(List<Integer> res , TreeNode root) {
        // basecase
        if (root == null) return;
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }

        // recursive rule
        helper(res, root.left);
        helper(res, root.right);
    }
}
