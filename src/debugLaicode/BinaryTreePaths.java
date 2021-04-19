package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        helper(root, res, path);
        return res;
    }
    // backtracking
    private void helper(TreeNode root, List<String> res, StringBuilder path) {
        // basecase
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            // leaf
            int len = path.length();
            path.append(root.val);
            res.add(path.toString());
            path.setLength(len);
            return;
        }

        // recursive rule
        int len = path.length();
        path.append(root.val).append("->");
        helper(root.left, res, path);
        helper(root.right, res, path);
        path.setLength(len); // backtrakcing
    }
}
