package debugLaicode;

import java.util.*;

/*
* solution:
* check two things
* - is complete tree, can be done by BFS level order traverse
* - for each node, if node.val < node.left.val  && node.val < node.right.val
* */
public class DetermineIfBinaryTreeIsMinHeap {
    public boolean isMinHeap(TreeNode root) {
        // Write your solution here
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean find = false; // flag to determin if we have seen a non-full node
        while (!queue.isEmpty()) {
            // expand
            TreeNode cur = queue.poll();
            // generate rule
            if (cur.left != null) {
                if (find) {
                    return false;
                }
                if (cur.left.key < cur.key) {
                    return false;
                }
                queue.offer(cur.left);
            } else {
                find = true;
            }
            if (cur.right != null) {
                if (find) {
                    return false;
                }
                if (cur.right.key < cur.key) {
                    return false;
                }
                queue.offer(cur.right);
            } else {
                find = true;
            }
        }
        return true;
    }
}
