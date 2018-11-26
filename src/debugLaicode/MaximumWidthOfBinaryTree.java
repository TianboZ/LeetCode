package debugLaicode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    // solution1: BFS
    public int widthOfBinaryTree1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, root));
        int max = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int left = -1;
            int right = -1;
            for (int i = 0; i < size; i++) {
                // expand
                Node cur = queue.poll();
                int curCol = cur.col;
                if (i == 0) {
                    left = curCol;
                }
                if (i == size - 1) {
                    right = curCol;
                }

                // generate rule
                if (cur.node.left != null) {
                    queue.offer(new Node(curCol * 2, cur.node.left));
                }
                if (cur.node.right != null) {
                    queue.offer(new Node(curCol * 2 + 1, cur.node.right));
                }
            }
            if (left != -1 && right != -1) {
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
    }
    class Node {
        TreeNode node;
        int col;
        Node(int col, TreeNode node) {
            this.col = col;
            this.node = node;
        }
    }
    // solution2: DFS
    int max = 1;
    public int widthOfBinaryTree(TreeNode root) {
        List<List<Integer>> width = new ArrayList<>();
        dfs(root, 0, width, 1);
        return max;
    }
    // input depth = 0
    private void dfs(TreeNode root, int depth, List<List<Integer>> width, int col) {
        if (root == null) return;

        if (width.size() < depth + 1) {
            width.add(new ArrayList<>());
            width.get(width.size() - 1).add(col);
        } else {
            width.get(depth).add(col);
            List<Integer> list = width.get(depth);
            max = Math.max(max, list.get(list.size() - 1) - list.get(0) + 1);
        }
        dfs(root.left, depth + 1, width, col * 2);
        dfs(root.right, depth + 1, width, col * 2 + 1);
    }
}
