package debugLaicode;

import java.util.*;

public class BinaryTreeZigzaglevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

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
            List<Integer> list = new ArrayList<>();
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

    public List<Integer> zigZag(TreeNode root) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        // sanity check
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        Deque<Integer> stack = new LinkedList<>();
        // initial
        q.offer(root);

        // terminate condition
        while (!q.isEmpty()) {
            int size = q.size();
            boolean isOdd = level % 2 == 0;

            for (int i = 0; i < size; i++) {
                // expand rule
                TreeNode curr = q.poll();
                if (isOdd) {
                    stack.offerFirst(curr.key);
                } else {
                    res.add(curr.key);
                }

                // generate rule
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            while (!stack.isEmpty()) {
                res.add(stack.pollFirst());
            }
            level++;
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        BinaryTreeZigzaglevelOrderTraversal zig = new BinaryTreeZigzaglevelOrderTraversal();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        zig.zigZag(a);
    }
}
