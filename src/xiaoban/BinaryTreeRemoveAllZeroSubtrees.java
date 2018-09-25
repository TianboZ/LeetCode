package xiaoban;

import debugLaicode.TreeNode;

public class BinaryTreeRemoveAllZeroSubtrees {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(0);

          /*        1
                   / \
                  1   0
                 / \
                 0  1
                /\
                0 0
          */

          node1.left = node2;
          node1.right = node3;
          node2.left = node4;
          node2.right = node5;
          node5.left = node6;
          node5.right = node7;

          BinaryTreeRemoveAllZeroSubtrees binaryTreeRemoveAllZeroSubtrees = new BinaryTreeRemoveAllZeroSubtrees();
          binaryTreeRemoveAllZeroSubtrees.isAllZero(node1);
          TreeNode res = node1;
        System.out.println("1");

    }
    private boolean isAllZero (TreeNode root) {
        // base-case
        if (root == null) return true;

        // recursive rule
        boolean left = isAllZero(root.left);
        boolean right  = isAllZero(root.right);

        if ( (root.left == null || left) && (root.right == null || right) && root.key == 0 ) {
            //root = null;
            root = null;
            return true;
        }
        return false;
    }

}
