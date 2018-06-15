package debugLaicode;

public class ReconstructBinarySearchTreeWithPostorderTraversal {
    public TreeNode reconstruct(int[] pre) {
        return helper(pre, 0, pre.length - 1);
    }

    private TreeNode helper(int[] pre, int start, int end) {
        // base-case
        if (start > end) {
            return null;
        }

        // recursive rule
        TreeNode root = new TreeNode(pre[start]);
        // [start + 1, index]: < root.key  [index + 1, end]: > root.key
        int index = -1;
        // find the last element's index that is smaller then root.key
        for (int i = start + 1; i <= end; i++) {
            if (pre[i] < root.key) {
                index = i;
            }
        }
        if (index == -1) {
            index = start;
        }

        root.left = helper(pre, start + 1, index);
        root.right = helper(pre, index + 1, end);
        return root;
    }
}
