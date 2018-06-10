package debugLaicode;

import java.util.*;

public class BinaryTreePostOrderIterativeTraversal {
    public List<TreeNode> postOrder(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            // pre-order: root, left, right
            // post-order: left, right, root.
            // root, right, left => reverse() => left, right, root
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }

            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            list.add(cur);
        }
        // root, right, left => reverse() => left, right, root
        Collections.reverse(list);
        return list;
    }
}
