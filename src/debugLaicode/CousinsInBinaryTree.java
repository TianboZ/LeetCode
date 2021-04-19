package debugLaicode;

import java.util.*;

public class CousinsInBinaryTree {
    /*
  - traverse tree, build Map<node, <parent, level>> map
  - look up map


  time o(n)
  space o(n)

  */

    class Cell {
        int val;
        int row;
        Cell(int v, int r) {
            val = v;
            row = r;
        }
    }
    Map<Integer, Cell> map = new HashMap<>();

    public boolean isCousins(TreeNode root, int x, int y) {
        // Write your solution here
        if (root == null) return false;
        dfs(root, root.val, 0);
        Cell c1 = map.get(x);
        Cell c2 = map.get(y);
        if (c1 != null && c2 != null) {
            return c1.row == c2.row && c1.val != c2.val;
        }
        return false;
    }

    private void dfs(TreeNode root, int parent, int row) {
        if (root == null) return;

        if (root.val != parent) {
            map.put(root.val, new Cell(parent, row));
        }
        dfs(root.left, root.val, row + 1);
        dfs(root.right, root.val, row + 1);
    }
}
