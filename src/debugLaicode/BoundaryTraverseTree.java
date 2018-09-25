package debugLaicode;

//Java program to print boundary traversal of binary tree

/* A binary tree node has data, pointer to left child
   and a pointer to right child */


import java.util.ArrayList;
import java.util.List;

public class BoundaryTraverseTree {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        TreeNode curr = root;
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.key);
        leftBoundary(root.left, res);
        leaves(root.left, res);
        leaves(root.right, res);
        rightBoundary(root.right, res);
        return res;
    }
    // preorder
    private void leaves(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            res.add(root.key);
        }
        leaves(root.left, res);
        leaves(root.right, res);
    }
    // preorder
    private void leftBoundary(TreeNode root, List<Integer> res) {
        if(root == null || (root.left == null && root.right == null)) return;
        res.add(root.key);
        if(root.left == null) leftBoundary(root.right, res);
        else leftBoundary(root.left, res);
    }
    // post order
    private void rightBoundary(TreeNode root, List<Integer> res) {
        if(root == null || (root.right == null && root.left == null)) return;
        if(root.right == null)rightBoundary(root.left, res);
        else rightBoundary(root.right, res);
        res.add(root.key); // add after child visit(reverse)
    }
}
