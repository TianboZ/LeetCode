package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    // return the height of subtree starts from root
    private int dfs(TreeNode root, List<List<Integer>> res) {
        // base-case
        if (root == null) {
            return 0;
        }
        // recursive rule
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        int currHeight = Math.max(left, right) + 1;
        if (res.size() < currHeight) {
            res.add(new ArrayList<>());
        }
        res.get(currHeight - 1).add(root.key);

        return currHeight;
    }
}
