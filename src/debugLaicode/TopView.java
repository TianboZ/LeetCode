package debugLaicode;

import java.util.*;
/*
*
*
* problem: traverse the tree, for each column, find the tree node with smallest level
*
* sol1: DFS
* sol2: BFS
*
* */
public class TopView {
    // sol1:
    int leftmost = 0;
    int rightmost = 0;
    public List<Integer> topView(TreeNode root) {
        // key: column  value: Wrapper
        Map<Integer, Wrapper> map = new HashMap<>();
        preorder(root, 0, 0, map);
        List<Integer> res = new ArrayList<>();
        for (int i = leftmost; i <= rightmost; i++) {
		    res.add(map.get(i).node.key);
        }
        return res;
    }
    private void preorder(TreeNode root, int col, int level, Map<Integer, Wrapper> map) {
        // base-case
        if (root == null) return;

        // recursive rule
        Wrapper top = map.get(col);

        // update left right boudary
        leftmost = Math.min(leftmost, top.col);
        rightmost = Math.max(rightmost, top.col);

        if (top == null) {
            map.put(col, new Wrapper(root, col, level));
        } else {
            if (level < top.level) {
                map.put(col, new Wrapper(root, col, level));
            }
        }

        preorder(root.left, col - 1, level + 1, map);
        preorder(root.right, col + 1, level + 1, map);
    }
    class Wrapper {
        TreeNode node;
        int col;
        int level;
        Wrapper(TreeNode node, int col, int level) {
            this.node = node;
            this.level = level;
            this.col = col;
        }
    }


    // sol2:
    private static class Cell {
        int col;
        TreeNode node;
        Cell(int _col, TreeNode _node) {
            col = _col;
            node = _node;
        }
    }
    public List<Integer> topView2(TreeNode root) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Map<Integer, Integer> map = new HashMap<>(); // key: column, value: treenode's key, this treenode is the smallest level
        Queue<Cell> q  = new LinkedList<>();
        int left = 0;
        int right = 0;

        // initial
        q.offer(new Cell(0, root));

        // terminate condition
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Cell curr = q.poll();
                if (!map.containsKey(curr.col)) {
                    map.put(curr.col, curr.node.key);
                    left = Math.min(left, curr.col);
                    right = Math.max(right, curr.col);
                }

                if (curr.node.left != null) {
                    q.offer(new Cell(curr.col - 1, curr.node.left));
                }

                if (curr.node.right != null) {
                    q.offer(new Cell(curr.col + 1, curr.node.right));
                }
            }
        }
        for (int i = left; i <= right; i++) {
            res.add(map.get(i));
        }
        return res;
    }




}
