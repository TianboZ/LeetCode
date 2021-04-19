package debugLaicode;

import practice.MaxHeap;

import java.util.*;

public class VerticalTraversalBinaryTree {
    // 2020
    public List<Integer> verticalOrder1(TreeNode root) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();

        // sanity check
        if (root == null) return res;

        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = 0;
        int max = 0;

        Queue<Cell> q = new LinkedList<>();

        // initial
        q.offer(new Cell(root, 0));

        // terminate
        while (!q.isEmpty()) {
            // expand
            Cell curr = q.poll();
            List<Integer> list = map.get(curr.col);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(curr.node.key);
            map.put(curr.col, list);

            // update min, max
            min = Math.min(min, curr.col);
            max = Math.max(max, curr.col);

            // generate
            if (curr.node.left != null) {
                q.offer(new Cell(curr.node.left, curr.col - 1));

            }
            if (curr.node.right != null) {
                q.offer(new Cell(curr.node.right, curr.col + 1));

            }
        }

        for (int i = min; i <= max; i++) {
            for (Integer n : map.get(i)) {
                res.add(n);
            }
        }

        return res;

    }
    private static class Cell {
        TreeNode node;
        int col;
        int row;
        Cell(TreeNode n, int c) {
            node = n;
            col = c;
        }
        Cell(TreeNode n, int c, int r) {
            node = n;
            col = c;
            row = r;
        }
    }


    // LC 987. Vertical Order Traversal of a Binary Tree
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Cell>> map = new HashMap<>(); // key: col value: tree nodes of column
        Queue<Cell> q = new LinkedList<>();
        int left = 0;
        int right = 0;

        // initial
        q.offer(new Cell(root, 0));

        while (!q.isEmpty()) {
            // expand
            Cell curr = q.poll();
            int col = curr.col;
            TreeNode node = curr.node;

            List<Cell> list = map.get(col);
            if (list == null) {
                list = new ArrayList<>();
                map.put(col, list);
            }
            list.add(curr);

            // generate
            if (node.left != null) {
                left = Math.min(left, col  -1 );
                q.offer(new Cell( node.left, col - 1));
            }
            if (node.right != null) {
                right = Math.max(right, col + 1);
                q.offer(new Cell(node.right, col + 1));
            }
        }

        for (int i = left; i <= right; i++) {
            // sort
            List<Cell> cells = map.get(i);
            cells.sort((c1, c2) -> {
                if (c1.row == c2.row) {
                    return c1.node.val -  c2.node.val;
                }
                return c1.row - c2.row;
            });

            // build result
            List<Integer> list = new ArrayList<>();
            for (Cell c : cells) {
                list.add(c.node.key);
            }
            res.add(list);
        }
        return res;
    }
}

// time O(n)  n is # of tree nodes
// space O(n)
