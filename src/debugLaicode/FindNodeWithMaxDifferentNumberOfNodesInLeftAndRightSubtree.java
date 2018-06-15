package debugLaicode;

public class FindNodeWithMaxDifferentNumberOfNodesInLeftAndRightSubtree {
    TreeNode res;
    int max;

    public TreeNode find(TreeNode root) {
        res = null;
        max = Integer.MIN_VALUE;
        findMaxDiff(root);
        return res;
    }

    // largestSmaller total number of nodes in the tree with root
    private int findMaxDiff(TreeNode root) {
        // base-case
        if (root == null) {
            return 0;
        }
        // recursive rule
        int left = findMaxDiff(root.left);
        int right = findMaxDiff(root.right);
        if (Math.abs(left - right) > max) {
            max = Math.abs(left - right);
            res = root;
        }
        return left + right + 1;
    }
}
