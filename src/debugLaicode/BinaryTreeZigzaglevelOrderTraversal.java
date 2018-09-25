package debugLaicode;

import java.util.*;

public class BinaryTreeZigzaglevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> open = new LinkedList<>();
        // initial
        open.offer(root);
        int level = 0;
        // terminate
        while (!open.isEmpty()) {
            int size = open.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                // expand
                TreeNode curr = open.poll();
                list.add(curr.key);

                // generate
                if (curr.left != null) {
                    open.add(curr.left);
                }
                if (curr.right != null) {
                    open.add(curr.right);
                }
            }
            // finished expend this layer
            if (level % 2 == 1) {
                Collections.reverse(list);
            }
            result.add(list);
            level++;
        }
        return result;
    }
}
