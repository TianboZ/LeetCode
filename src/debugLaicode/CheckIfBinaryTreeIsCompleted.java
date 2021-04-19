package debugLaicode;

import java.util.LinkedList;
import java.util.Queue;

/*
* sol1 BFS
* sol2 DFS
*
* */
public class CheckIfBinaryTreeIsCompleted {
    public boolean isCompleted(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();

        boolean flag = false; // mark true when we first seen a non full node

        // initial
        q.offer(root);

        while (!q.isEmpty()) {
            // expand
            TreeNode curr = q.poll();
            // generate rule

            if (curr.left == null) {
                flag = true;
            } else {
                if (flag) return false;
                q.offer(curr.left);
            }

            if (curr.right == null) {
                flag = true;
            } else {
                if (flag) return false;
                q.offer(curr.right);
            }
        }

        return true;
    }
}
