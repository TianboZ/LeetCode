package debugLaicode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfBinaryTreeIsCompleted {
    public boolean isCompleted(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();

        boolean flag = false;

        // initial
        q.offer(root);

        while (!q.isEmpty()) {
            // how many nodes on this layer
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // expand
                TreeNode curr = q.poll();

                // generate
                if (curr.left == null) {
                    flag = true;
                } else if (flag) {
                    // if the flag is true, then this node still can generate child, then tree is not completed
                    return false;
                } else {
                    // the flag is not set, and this node has left child
                    q.offer(curr.left);
                }

                // same logic applied to the right child
                if (curr.right == null) {
                    flag = true;
                } else if (flag) {
                    return false;
                } else {
                    q.offer(curr.right);
                }
            }

        }

        return true;
    }
}
