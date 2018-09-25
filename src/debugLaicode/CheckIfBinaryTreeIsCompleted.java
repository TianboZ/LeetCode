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
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // expand
                TreeNode curr = q.poll();
                // generate rule
                // left node
                if (curr.left != null && flag) {
                    return false;
                } else if (curr.left != null && !flag) {
                    q.offer(curr.left);
                } else {
                    flag = true;
                }

                // right node
                if (curr.right != null && flag) {
                    return false;
                } else if (curr.right != null && !flag) {
                    q.offer(curr.right);
                } else {
                    flag = true;
                }
            }
        }


        return true;
    }
}
