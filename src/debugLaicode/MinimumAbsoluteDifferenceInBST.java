package debugLaicode;
/*
Solution:
inorder traverse BST, then treeNode's value is sorted
keep a previous node value

time  O(n)
space O(n)

*/
public class MinimumAbsoluteDifferenceInBST {
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }
    TreeNode prev = null;
    int min = Integer.MAX_VALUE;
    private void inorder(TreeNode root) {
        if (root ==null) return;

        inorder(root.left);
        if(prev == null) {
            prev = root;
        } else {
            min = Math.min(min, Math.abs(prev.key - root.key));
            prev = root;
        }
        inorder(root.right);
    }
}
