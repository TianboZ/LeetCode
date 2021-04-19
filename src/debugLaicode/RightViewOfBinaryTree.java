package debugLaicode;

import java.util.*;

public class RightViewOfBinaryTree {
    public List<Integer> rightView(TreeNode root) {

        // Write your solution here
        // sanity check
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (i == size - 1) res.add(curr.key);

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);

            }
        }
        return res;

    }
}
