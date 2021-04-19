package MianJing.ixl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int v) {
        val = v;
    }
}

/*
 *           2
 *          /  \
 *         5    3
 *               /\
 *               4  1
 *
 *
 * solution:
 * - traverse the binary tree, store each node's value.
 * - sort node values
 * - 2nd pass traverse, in order traverse,  assign new value to each node
 *(BST inorder traverse is increasing order)
 *
 * complexity:
 * time o(n)
 * space o(n)
 *
 * */

public class BinaryTreeToBST {
    List<Integer> pre  = new ArrayList<>(); // store preorder nodes value

    int i = 0;

    public void convert(TreeNode root) {
        dfs(root);
        pre.sort((n1, n2) -> n1 - n2);

        inorder(root);

        System.out.println(root);
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        pre.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    // inorder traverse original tree, assign new value to each node
    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        root.val = pre.get(i);
        i++;

        System.out.println(root.val);

        inorder(root.right);
    }

    private TreeNode clone(TreeNode root) {
        if (root == null) return null;

        TreeNode root2 = new TreeNode(root.val);  // cloned root node
        root2.left = clone(root.left);
        root2.right = clone(root.right);
        return root2;
    }

    public  static void main(String[] strs) {
        BinaryTreeToBST sol = new BinaryTreeToBST();
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        /*
        *           2
        *          /  \
        *         5    3
        *               /\
        *               4  1
        * */


        n3.left = n1;
        n3.right = n4;
        n4.left = n5;
        n4.right = n2;

        sol.convert(n3);
    }
}
