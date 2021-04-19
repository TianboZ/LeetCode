package debugLaicode;

/*

            1
           / \
          2   1
         /\   /\
        2  2  1 1
       /
       2

getHeight() take o(logn),
worst case, call getHeight() log(n)  times

time: O(logn * logn)
space: O(logn)
* */

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        // Write your solution here
        if (root == null) return 0;

        int leftH = leftHeight(root.left);
        int rightH = rightHeight(root.right);
        if (leftH == rightH) {
            return ((int)Math.pow(2, leftH + 1) - 1);
        }

        return countNodes(root.left) + countNodes(root.right)  + 1;
    }

    private int leftHeight(TreeNode root){
        if (root == null) return 0;
        return leftHeight(root.left) + 1;
    }
    private int rightHeight(TreeNode root){
        if (root == null) return 0;
        return rightHeight(root.right) + 1;
    }
}
