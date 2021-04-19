package debugLaicode;

import java.util.LinkedList;
import java.util.Queue;

/*
*
* sol1: DFS
* sol2: BFS
* */
public class MinimumDepthOfBinaryTree {
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        helper(root, 0);
        return min;
    }
    private void helper(TreeNode root, int count) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            // leaf
            min = Math.min(min, count + 1);
            return;
        }

        // recursive rule
        helper(root.left, count + 1);
        helper(root.right, count + 1);
    }

    public int minDepth2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int level = 1;

        //initial
        q.offer(root);

        // terminate
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // expand
                TreeNode curr = q.poll();

                if (curr.left == null && curr.right == null) {
                    // first leaf, shortest path
                    return level;
                }

                // generate
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            level++;
        }

        return 0;
    }
}
