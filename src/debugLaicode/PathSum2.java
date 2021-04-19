package debugLaicode;

import java.util.*;

// LC
public class PathSum2 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, 0);
        return res;
    }

    private void helper( TreeNode root, int target, int currSum) {
        // base-case
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            // leaf
            if (currSum + root.val == target) {
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }

        // recursive rule
        path.add(root.val);
        helper(root.left, target, currSum + root.val);
        helper(root.right, target, currSum + root.val);
        path.remove(path.size() - 1);
    }
}


// time o(n^2)
// space o(n^2)