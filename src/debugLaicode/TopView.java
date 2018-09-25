package debugLaicode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopView {
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

}
