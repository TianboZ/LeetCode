package debugLaicode;

import java.util.*;


/*
* sol1: partial sort
*
*

traverse the tree, keep track each node position, store them in map
    - map<column, list<Node>>

after it, we can sort list<Node> by
    - sort by row
    - sort by value


Node {
    int val;
    int row;
    int col;
}

complexity:
time  O(n + nlogn) worst case


*
* sol2: global sort
*
*
* see the diff with LC314
* https://leetcode.com/problems/binary-tree-vertical-order-traversal/
* */
public class VerticalOrderTraversalOfBinaryTree {
    class Node {
        int row;
        int col;
        int val;
        Node(int r, int c, int v) {
            row = r;
            col = c;
            val = v;
        }
    }
    Map<Integer, List<Node>> map = new HashMap<>();
    int left = 0;
    int right = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        dfs(root, 0, 0);

        List<List<Integer>> res = new ArrayList<>();

        // sort
        for (int col = left; col <= right; col++) {
            List<Node> nodes = map.get(col);
            nodes.sort((a, b) -> {
                if (a.row == b.row) {
                    return a.val - b.val;
                }
                return a.row - b.row;
            });

            // put sorted nodes into res
            List<Integer> tmp = new ArrayList<>();
            for (Node n : nodes) {
                tmp.add(n.val);
            }
            res.add(tmp);
        }

        return res;

    }
    private void dfs(TreeNode root, int row, int col) {
        if (root == null) return;

        List<Node> list = map.get(col);
        if(list == null) {
            list = new ArrayList<>();
            map.put(col, list);
        }
        map.get(col).add(new Node(row, col, root.val));

        left = Math.min(left, col);
        right = Math.max(right, col);

        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }
}
